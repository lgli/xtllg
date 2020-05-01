/**
 * 基于jQuery封装的组件方法
 * @author lgli
 * @since 1.0
 * @date 2020-04-28
 */
(function($){

    /**
     * 判断对象是否为空
     * 未定义也算空
     * @param param
     * @returns {boolean}
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
     * @param param
     * @returns {boolean}
     */
    $.isNullString=function(param){
        if(this.isNullObject(param)){
            return true;
        }
        if(param.trim() == ''){
            return true;
        }
        return false;
    }
})(jQuery);