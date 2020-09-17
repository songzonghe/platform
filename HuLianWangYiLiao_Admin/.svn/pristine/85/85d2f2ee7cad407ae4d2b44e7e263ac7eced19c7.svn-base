
/**
 * data-find  等于 find 带输入框
 * data-width  选择框宽度
 * data-select-width  选择项框宽度
 * data-title  选择项标题 用 ; 分隔  
 * data-show-title 选中时需要展示的列数
 * 
 * 注意 有多个选择项时 内容用 ;; 分隔 （两个分号，防止内容中存在分号）
 */

(function($){

  $.searchableSelect = function(element, options) {
    this.element = element;
    this.options = options || {};
    this.init();
    var _this = this;
    this.element.next().next('.searchable-select').remove();
    var nextwidth=this.element.attr('data-width');
    if(!isUndefinedAndEmpty(nextwidth)){
   		this.element.next('.searchable-select').attr('style','height:32px;min-width:0px !important;width:'+nextwidth+";");
    }
    var showwidth=this.element.attr('data-select-width');
    if(!isUndefinedAndEmpty(showwidth)){
    	this.element.next('.searchable-select').find('.searchable-select-dropdown').attr('style','width:'+showwidth+";");
    }
     var nexttitle=this.element.attr('data-title');
    if(!isUndefinedAndEmpty(nexttitle) && $.trim(nexttitle).length>0){
    	var titlelist=nexttitle.split(';');
      	var titles='';
      	for(var i=0;i<titlelist.length;i++){
      		if(titlelist[i].indexOf(':')!=-1){
      			titles+='<span class="select-item-span" style="width:'+titlelist[i].split(':')[1]+'">'+titlelist[i].split(':')[0]+'</span>';
      		}else{
      			titles+='<span class="select-item-span" >'+titlelist[i]+'</span>';
      		}
      	}
   		this.element.next('.searchable-select').find('.searchable-select-title').html(titles);
    }
    
    this.searchableElement.on('keydown', function(event){
      if (event.which === 13 || event.which === 40 || event.which == 38){
        event.preventDefault();
        if(_this.searchableElement.find('.searchable-select-dropdown').hasClass('searchable-select-hide')){
        	_this.show();
        }else{
        	 if(event.which === 13){         //enter
    	        event.preventDefault();
    	        _this.selectCurrentHoverItem();
    	        _this.hide();
        	   }
        	   else if (event.which == 27) { //ese
                _this.hide();
              } else if (event.which == 40) { //down
                _this.hoverNextItem();
              } else if (event.which == 38) { //up
                _this.hoverPreviousItem();
              }
        }
      }
    });
    
    
    $(document).on('click', null, function(event){
    	if(_this.searchableElement.has($(event.target)).length === 0){
    		_this.hide();return;
    	}else if(_this.searchableElement.find('.searchable-select-dropdown').hasClass('searchable-select-hide')){
		    _this.show();return;
    	}else if(_this.searchableElement.find('.searchable-select-caret').is($(event.target)) || _this.searchableElement.find('.searchable-select-holder').is($(event.target))){
    		_this.hide();return;
    	}else{
    		_this.input.focus();
    	}
    });
    this.input.on('keyup', function(event){
      if(event.which != 13 && event.which != 27 && event.which != 38 && event.which != 40){
        _this.filter();
      }
    })
  }
  var $sS = $.searchableSelect;
  $sS.fn = $sS.prototype = {
    version: '0.0.1'
  };

  $sS.fn.extend = $sS.extend = $.extend;

  $sS.fn.extend({
    init: function(){
      var _this = this;
      this.element.hide();
      this.searchableElement = $('<div tabindex="0" class="searchable-select"></div>');
      this.holder = $('<div class="searchable-select-holder"></div>');
      this.dropdown = $('<div class="searchable-select-dropdown searchable-select-hide"></div>');
      if(this.element.attr('data-find')=='find'){
    	  this.input = $('<input type="text" class="searchable-select-input" />');
      }else{
    	  this.input = $('<input type="hidden"  class="searchable-select-input" />');
      }
      this.title = $('<div class="searchable-select-title"></div>');
      this.items = $('<div class="searchable-select-items"></div>');
      this.caret = $('<span class="searchable-select-caret"></span>');
      this.scrollPart = $('<div class="searchable-scroll"></div>');
      
      this.dropdown.append(this.input);
      if(!isUndefinedAndEmpty(this.element.attr('data-title')) && $.trim(this.element.attr('data-title')).length>0){
    	  this.dropdown.append(this.title);
      }
      this.dropdown.append(this.scrollPart);
      this.scrollPart.append(this.items);
      this.searchableElement.append(this.caret);
      this.searchableElement.append(this.holder);
      this.searchableElement.append(this.dropdown);
      this.element.after(this.searchableElement);
      this.buildItems();
    },
    
    filter: function(){
      var text = this.input.val();
      this.items.find('.searchable-select-item').each(function(){
    	  if($(this).text().toUpperCase().indexOf(text.toUpperCase()) !=-1){
    		  $(this).removeClass('searchable-select-hide');
    	  }else{
    		  $(this).addClass('searchable-select-hide');
    	  }
      });
    },
    
    hoverFirstNotHideItem: function(){
      this.hoverItem(this.items.find('.searchable-select-item:not(.searchable-select-hide)').first());
    },
    
    hoverNotHideItem: function(){
    	if(this.items.find('.hover:not(.searchable-select-hide)').length>0){
    		this.hoverItem(this.items.find('.hover:not(.searchable-select-hide)'));
        }else if(this.items.find('.selected:not(.searchable-select-hide)').length>0){
        	this.hoverItem(this.items.find('.selected:not(.searchable-select-hide)'));
        }else{
        	 this.hoverFirstNotHideItem();
        }
    },

    selectCurrentHoverItem: function(){
    	this.hoverNotHideItem();
      if(!this.currentHoverItem.hasClass('searchable-select-hide'))
        this.selectItem(this.currentHoverItem);
    },

    hoverPreviousItem: function(){
    	this.hoverNotHideItem();
        var prevItem = this.currentHoverItem.prevAll('.searchable-select-item:not(.searchable-select-hide):first')
        if(prevItem.length > 0)
          this.hoverItem(prevItem);
    },
    
    hoverNextItem: function(){
    	this.hoverNotHideItem();
        var nextItem = this.currentHoverItem.nextAll('.searchable-select-item:not(.searchable-select-hide):first')
        if(nextItem.length > 0)
          this.hoverItem(nextItem);
    },
    buildItems: function(){
      var _this = this;
      var titlelist=[];
      if(!isUndefinedAndEmpty(this.element.attr('data-title')) &&  $.trim(this.element.attr('data-title')).length>0){
      	 titlelist=this.element.attr('data-title').split(';');
      }
      this.element.find('option:not(.isHide)').each(function(){
      var item;
      if($(this).text().length>0 && $(this).text().lastIndexOf(';;')!=-1){
      	var items=$(this).text().split(';;');
      	var texts='';
      	for(var i=0;i<items.length;i++){
      		if(!isUndefinedAndEmpty(titlelist[i]) && titlelist[i].indexOf(':')!=-1){
    			texts+='<span class="select-item-span" style="width: '+titlelist[i].split(':')[1]+'" >'+items[i]+'</span>';
    		}else{
    			texts+='<span class="select-item-span" style="width: 30%" >'+items[i]+'</span>';
    		}
      	}
      	item = $('<div class="searchable-select-item" data-value="'+$(this).attr('value')+'">'+texts+'</div>');
      }else{
    	  if(titlelist.length>0){
    		  item = $('<div class="searchable-select-item" data-value="'+$(this).attr('value')+'"><span class="select-item-span" style="width: 100%;text-align: center;" >'+$(this).text()+'</span></div>');
    	  }else{
    		  item = $('<div class="searchable-select-item" data-value="'+$(this).attr('value')+'">'+$(this).text()+'</div>');
    	  }
      }

        if(this.selected){
          _this.selectItem(item);
          _this.hoverItem(item);
        }
        var this_option = this;
        item.on('mouseenter', function(){
        	$('.hover').removeClass('hover');
        	$(this).addClass('hover');
        }).on('mouseleave', function(){
          $(this).removeClass('hover');
        }).click(function(event){
          event.stopPropagation();
          _this.selectItem($(this));
          _this.hide();
        });
        var selectOnchange =  $(this_option).parent().attr('onchange');
    	if(!isUndefinedAndEmpty(selectOnchange)){
    		var this_select_id = $(this_option).parent();
    		var selectOnchangeName = selectOnchange.substring(0,selectOnchange.indexOf('('));
    		item.bind('click',function(){
    			var strlist=selectOnchange.substring(selectOnchange.indexOf('(')+1,selectOnchange.indexOf(')')).split(',');
    			for(var a=0;a<strlist.length;a++){
    				if(strlist[a]=='this'){
    					strlist[a]=this_select_id;
    				}
    			}
    			doCallback(eval(selectOnchangeName),strlist);
    		})
    	}
        _this.items.append(item);
      });
    },
    show: function(){
      $('.hover').removeClass('hover');
      this.dropdown.removeClass('searchable-select-hide');
      this.status = 'show';
      this.filter();
      this.input.focus();
    },

    hide: function(){
      if(!(this.status === 'show')) return;
      if(this.items.find(':not(.searchable-select-hide)').length === 0)
      this.input.val('');
      this.dropdown.addClass('searchable-select-hide');
      this.status = 'hide';
      this.dropdown.parents('.searchable-select').prev().blur();
    },

    hasCurrentSelectedItem: function(){
      return this.currentSelectedItem && this.currentSelectedItem.length > 0;
    },

    selectItem: function(item){
      if(this.hasCurrentSelectedItem())
      this.currentSelectedItem.removeClass('selected');
      this.currentSelectedItem = item;
      item.addClass('selected');
      this.hoverItem(item);
      if(!isUndefinedAndEmpty(item.find('span').text())){
    	  if(!isUndefinedAndEmpty(this.element.attr('data-show-title'))){
    		  var showText=item.find('span:eq('+this.element.attr('data-show-title')+')').text();
    		  if(isUndefinedAndEmpty(showText)){
    			  showText=item.text();
    		  }
    		  this.holder.text(showText);
    	  }else{
    		  this.holder.text(item.find('span:last').text());
    	  }
      }else{
     	 this.holder.text(item.text());
      }
      var value = item.data('value');
      this.holder.data('value', value);
      this.element.val(value);
      if(this.options.afterSelectItem){
        this.options.afterSelectItem.apply(this);
      }
    },

    hasCurrentHoverItem: function(){
      return this.currentHoverItem && this.currentHoverItem.length > 0;
    },

    hoverItem: function(item){
      if(this.hasCurrentHoverItem()){
    	$('.hover').removeClass('hover');
      }
      if(item.outerHeight() + item.position().top > this.items.height())
          this.items.scrollTop(this.items.scrollTop() + item.outerHeight() + item.position().top - this.items.height());
        else if(item.position().top < 0)
          this.items.scrollTop(this.items.scrollTop() + item.position().top);
      this.currentHoverItem = item;
      item.addClass('hover');
    },
  });

  $.fn.searchableSelect = function(options){
    this.each(function(){
      var sS = new $sS($(this), options);
    });
    return this;
  };
  $(function(){
		$('.select').searchableSelect();//加载
	});
})(jQuery);

