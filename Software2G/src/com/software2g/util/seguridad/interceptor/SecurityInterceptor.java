package com.software2g.util.seguridad.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;
//import org.apache.tomcat.util.bcel.classfile.Constant; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.software2g.portal.action.PortalAction;
import com.software2g.vo.Usuario;

public class SecurityInterceptor extends AbstractInterceptor implements com.opensymphony.xwork2.interceptor.Interceptor, StrutsStatics{
	
	private static final long serialVersionUID = 1L;

	public void destroy(){
		System.out.println("destroy-******************");
	}

    public void init(){
    	System.out.println("init*********************");
    }

    public String intercept(ActionInvocation invocation) throws Exception{    	
    	@SuppressWarnings("rawtypes")
		Map session = invocation.getInvocationContext().getSession();
    	
    	System.out.println("-------------------------------------------------------------");
    	System.out.println("-------------------------------------------------------------");
    	final ActionContext context = invocation.getInvocationContext();
    	HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
    	HttpSession session2 = (HttpSession)request.getSession();
    	Usuario user = (Usuario) session2.getAttribute("usuarioVO");
    	if(user!=null){
    		System.out.println("Usuario cargado en session!!!!!!!");
    		System.out.println("nombre: ["+user.getPersona().getNombreCompleto()+"]");
    	}else
    		System.out.println("usuario no cargado en session!!!!!!!!");
    	System.out.println("-------------------------------------------------------------");
    	System.out.println("-------------------------------------------------------------");
    	
    	System.out.println("-------------------------------------------------------------");
    	System.out.println("-------------------------------------------------------------");
    	System.out.println("session: ["+session+"]");
    	System.out.println("Entra esta parte .....................");
    	System.out.println("invocation.getAction(): ["+invocation.getAction().toString()+"]");
    	//invocation.getStack()
    	//HttpServletRequest request = (HttpServletRequest)((ActionContext)invocation.getInvocationContext()).get 
    	
    	
    	PortalAction a = (PortalAction)invocation.getAction();
    	System.out.println("a.getUsuarioVO(): ["+a.getUsuarioVO()+"]");
    	System.out.println("a.PersonaVO(): ["+a.getPersonaVO()+"]");
    	System.out.println("a.GestionFacadePortal(): ["+a.getGestionFacadePortal()+"]");
    	System.out.println("a: ["+a+"]");
    	System.out.println("invocation.getAction(): ["+invocation.getAction()+"]");
    	if(a.getUsuarioVO()!=null&&a.getUsuarioVO().getLoginUsua()!=null&&a.getUsuarioVO().getPasswordUsua()!=null){
    		System.out.println("login:["+a.getUsuarioVO().getLoginUsua()+"]");
    		System.out.println("password: ["+a.getUsuarioVO().getPasswordUsua()+"]");
    	}else
    		System.out.println("usuario y passwors son NULL!!!!!!!!!!!!!!!!!");
    	System.out.println("-------------------------------------------------------------");
    	System.out.println("-------------------------------------------------------------");
    	
    	
    	
    	if (session.get("usuarioVO") == null) {
        	//return Action.ERROR;
        	System.out.println("Error usuario no esta en la sesion");
        	System.out.println("invocation.invoke(): ["+invocation.toString()+"]");
        	//invocation.
        	return invocation.invoke();
        } else {
        	System.out.println("******************************************");
        	System.out.println("usuarioVO esta en session!!!!!!!!");
        	return invocation.invoke();
        }

    }
}
