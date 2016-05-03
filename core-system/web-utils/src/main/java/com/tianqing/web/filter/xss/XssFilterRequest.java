package com.tianqing.web.filter.xss;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Xss过滤包装请求类
 * Created by hyb on 2016/4/25.
 */
@Slf4j
public class XssFilterRequest extends HttpServletRequestWrapper {

    private final static String JAVASCRIPT_KEYWORD_REGEX ="^.*(ACX|SCRIPT|JAVASCRIPT|ALERT|WINDOW|BREAK|DELETE|FUNCTION|RETURN|TYPEOF|CASE|IF|SWITCH|VAR|CATCH|ELSE|THIS|VOID|CONTINUE|FALSE|INSTANCEOF|THROW|WHILE|DEBUGGER|FINALLY|NEW|TRUE|DEFAULT|FOR|NULL|TRY|ABSTRACT|DOUBLE|GOTO|NATIVE|STATIC|BOOLEAN|ENUM|IMPLEMENTS|PACKAGE|SUPER|BYTE|EXPORT|IMPORT|PRIVATE|SYNCHRONIZED|EXTENDS|INT|PROTECTED|THROWS|CLASS|FINAL|INTERFACE|PUBLIC|TRANSIENT|CONST|FLOAT|LONG|SHORT|VOLATILE).*$";
    private final static String JAVA_KEYWORD_REGEX = "^.*(JAVA|CLASS|ABSTRACT|ASSERT|BOOLEAN|BREAK|BYTE|CASE|CATCH|CLASS|CONSTCONTINUE|DEFAULT|DODOUBLE|ELSEENUM|EXTENDS|FINAL|FINALLY|FLOATFOR|GOTO|IF|IMPLEMENTS|IMPORTINSTANCEOF|INT|INTERFACE|LONG|NATIVENEW|PACKAGE|PRIVATE|PROTECTED|PUBLICRETURN|STRICTFP|SHORT|STATIC|SUPERSWITCH|SYNCHRONIZED|THIS|THROW|THROWSTRANSIENT|TRY|VOID|VOLATILE|WHILE).*$";
    private final static String EVENT_KEYWORD_REGEX = "^.*(CLICK|DBLCLICK|MOUSEDOWN|MOUSEUP|MOUSEOVER|MOUSEMOVE|MOUSEOUT|KEYPRESS|KEYDOWN|KEYUP|ABORT|BEFOREUNLOAD|ERROR|MOVE|RESIZE|SCROLL|STOP|UNLOAD|BLUR|CHANGE|FOCUS|RESET|SUBMIT|BOUNCE|FINISH|START|BEFORECOPY|BEFORECUT|BEFOREEDITFOCUS|BEFOREPASTE|BEFOREUPDATE|CTEXTMENU|COPY|CUT|DRAG|DRAGDROP|DRAGEND|DRAGENTER|DRAGLEAVE|DRAGOVER|DRAGSTART|DROP|LOSECAPTURE|PASTE|SELECT|SELECTSTART|AFTERUPDATE|CELLCHANGE|DATAAVAILABLE|DATASETCHANGED|DATASETCOMPLETE|ERRORUPDATE|ROWENTER|ROWEXIT|ROWSDELETE|ROWSINSERTED|AFTERPRINT|BEFOREPRINT|FILTERCHANGE|HELP|PROPERTYCHANGE|READYSTATECHANGE\n).*$";

    public XssFilterRequest(ServletRequest request) {
        super((HttpServletRequest)request);
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/>
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String s) {
        String value = super.getHeader(s);
        if (value != null) {
            value = this.singleFilter(value);
        }
        return value;
    }

    /**
     * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
     * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
     */
    @Override
    public String getParameter(String s) {
        String parameter = super.getParameter(s);
        parameter=this.singleFilter(parameter);
        return parameter;
    }

    @Override
    public String[] getParameterValues(String name){
        String[] paramterValues=super.getParameterValues(name);
        return this.paramsFilter(paramterValues);
    }

    /**
     * 将所有的请求参数中的特殊字符转义
     * @param parameters 所有的请求参数
     * @return 特殊字符转义后的参数组
     */
    private static String[] paramsFilter(String[] parameters) {
        if(parameters!=null && parameters.length>0){
            int length = parameters.length;
            String[] result=new String[length];
            for (int i = 0; i <length; i++) {
                result[i]= singleFilter(parameters[i]);
            }
        }
        return null;
    }

    /**
     * 将指定的请求参数中的特殊字符直接转义
     * @param parameter 单个请求参数
     * @return 特殊字符转义后的参数
     */
    private static String singleFilter(String parameter) {
        if (parameter != null && parameter.length()>0) {
            //验证敏感字符
            parameter = checkValForJs(parameter);
            parameter = checkValForJava(parameter);
            parameter = checkValForEvent(parameter);
            //转义特殊字符
            StringBuilder sb = new StringBuilder();
            char[] chars = parameter.toCharArray();
            for (int i = 0, length = chars.length; i < length; i++) {
                char c = parameter.charAt(i);
                switch (c) {
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    case '"':
                        sb.append("&quot;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    default:
                        sb.append(c);
                        break;
                }
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 验证JS敏感字符
     * @param parameter 请求参数
     * @return 请求参数值，不符合要求返回""
     */
    private static String checkValForJs(String parameter){
        boolean b = Pattern.matches(JAVASCRIPT_KEYWORD_REGEX, parameter.toUpperCase());
        return b?"":parameter;
    }
    /**
     * 验证JAVA敏感字符
     * @param parameter 请求参数
     * @return 请求参数值，不符合要求返回""
     */
    private static String checkValForJava(String parameter){
        boolean b = Pattern.matches(JAVA_KEYWORD_REGEX, parameter.toUpperCase());
        return b?"":parameter;
    }
    /**
     * 验证JS事件敏感字符
     * @param parameter 请求参数
     * @return 请求参数值，不符合要求返回""
     */
    private static String checkValForEvent(String parameter){
        boolean b = Pattern.matches(EVENT_KEYWORD_REGEX, parameter.toUpperCase());
        return b?"":parameter;
    }

    //=================以下方法未经过Xss过滤改造，已禁用==================//

    @Deprecated
    @Override
    public Enumeration<String> getParameterNames(){
        log.error("This method has been deprecated,it always return null");
        return null;
    }

    @Deprecated
    @Override
    public Map<String,String[]> getParameterMap(){
        log.error("This method has been deprecated,it always return null");
        return null;
    }

}
