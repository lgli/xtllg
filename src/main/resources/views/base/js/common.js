/**
 * 基于jQuery和VUE封装的组件方法
 * @author lgli
 * @since 1.0
 * @date 2020-04-28
 */
(function($,VUE){

    let tabArrs=[];

    /**
     * 判断对象是否为空
     * 未定义也算空
     * @param param 传入参数
     * @returns {boolean} 返回true 为空 否则不为空
     */
    $.isNullObject=function(param){
        if(param == null){
            return true
        }
        if(typeof(param) == 'undefined'){
            return true;
        }
        return false;
    };

    /**
     * 判断字符串是否为空
     * 多个空格也算空
     * 未定义也算空
     * @param param 参数
     * @returns {boolean} 返回true  为空   false 不为空
     */
    $.isNullString=function(param){
        if(this.isNullObject(param)){
            return true;
        }
        if(param.trim() == ''){
            return true;
        }
        return false;
    };


    /**
     * 打开新的iframe
     * @param option 属性设置
     * @param callback 关闭该页面回调方法
     */
    $.openNewIframe = function(option,callback){

    };

    /**
     * 初始化资源菜单控件
     * @param contentId 容器div
     * @param initIframe 初始化的tab iframe
     * @param initOpt 初始打开的tab iframe
     */
    $.initMenu=function(contentId,initIframe,initOpt){
        if(this.isNullObject(initIframe)){
            //传入空对象，则默认没有打开的tab -> iframe
            initIframe = [];
            initOpt = '';
        }
        if(this.isNullString(initOpt)){
            initOpt = '';
        }
        new Vue({
            el: '#'+contentId,
            data: function() {
                return {
                    editableTabsValue: initOpt,
                    editableTabs: initIframe,
                    meunTree:this.data
                }
            },
            methods: {
                //打开资源菜单
                openMenuUrl(e) {
                    /*打开资源菜单*/
                    //当前菜单url
                    let meunUrl = $(e.$el).attr('param');
                    this.addTab($(e.$el).html(),meunUrl);
                },
                //添加tab
                addTab(targetName,tabSrc) {
                    if($.isNullString(targetName) || $.isNullString(tabSrc)){
                        return;
                    }
                    //先判断是否已经打开过了，打开过则直接打开，否则新增一个tab
                    let isExist = false;
                    $.each(this.editableTabs,function(thisTabIndex,thisObj){
                        let openSourceUrl = thisObj.url;
                        if(openSourceUrl == tabSrc){
                            //已经存在
                            isExist = true;
                            return;
                        }
                    });
                    if(isExist){
                        //已经存在，打开存在的tab
                        this.editableTabsValue = tabSrc;
                        return;
                    }
                    this.editableTabs.push({
                        title: targetName,
                        name: tabSrc,
                        url: tabSrc
                    });
                    this.editableTabsValue = tabSrc;
                },
                //左键单击tab
                leftClickTab(thisTab){
                    //当前tab实例
                    console.log(thisTab);
                    //左侧菜单栏，需要选中
                    //todo



                },
                //移除tab
                removeTab(targetName) {
                    let tabs = this.editableTabs;
                    let activeName = this.editableTabsValue;
                    if (activeName === targetName) {
                        tabs.forEach((tab, index) => {
                            if (tab.name === targetName) {
                                let nextTab = tabs[index + 1] || tabs[index - 1];
                                if (nextTab) {
                                    activeName = nextTab.name;
                                }
                            }
                        });
                    }
                    this.editableTabsValue = activeName;
                    this.editableTabs = tabs.filter(tab => tab.name !== targetName);
                },
                handleClose(key,keypath){
                    //关闭时，关闭下面所有的菜单
                    console.log(this.$refs.thisElMenu);
                    console.log(this.meunTree);
                    console.log(keypath);
                }
            }
        });
    }
})(jQuery,Vue);