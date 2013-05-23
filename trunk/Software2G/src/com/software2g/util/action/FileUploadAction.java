package com.software2g.util.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	@SkipValidation
	public String execute() throws Exception{
		try {
			HttpServletRequest request11 = ServletActionContext.getRequest();
			System.out.println("*********************************************");
			System.out.println("*********************************************");
			System.out.println("request11: ["+request11+"]");
			System.out.println("*********************************************");
			System.out.println("*********************************************");
			System.out.println("getAbsolutePath: ["+getFileUpload().getAbsolutePath()+"]");
			System.out.println("request: ["+request+"]");
			System.out.println("getRequest: ["+getRequest()+"]");
			System.out.println("response: ["+response+"]");
			System.out.println("getResponse: ["+getResponse()+"]");
			if(request11!=null){
				System.out.println("request11: ["+request11.getContextPath()+"]");
				System.out.println("request11: ["+request11.getRealPath("/")+"]");
			}
			String filePath = request11.getRealPath("/");
			filePath += "PruebasUtil\\repositorioFileupload";
			System.out.println("Server path:" + filePath);
			File fileToCreate = new File(filePath, this.fileUploadFileName);
			FileUtils.copyFile(this.fileUpload, fileToCreate);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;

	}
	
	public String display() {
		return NONE;
	}

	
	public HttpServletRequest getRequest() {return request;}
	public void setRequest(HttpServletRequest request) {this.request = request;}
	public HttpServletResponse getResponse() {return response;}
	public void setResponse(HttpServletResponse response) {this.response = response;}
	public void setServletResponse(HttpServletResponse response) {this.response = response;}
	public void setServletRequest(HttpServletRequest request) {this.request = request;}

		
}