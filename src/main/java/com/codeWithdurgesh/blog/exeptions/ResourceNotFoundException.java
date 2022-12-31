package com.codeWithdurgesh.blog.exeptions;

public class ResourceNotFoundException extends RuntimeException{

	
	String resoueceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resoueceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s :%s ", resoueceName,fieldName,fieldValue));
		this.resoueceName = resoueceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResoueceName() {
		return resoueceName;
	}
	public void setResoueceName(String resoueceName) {
		this.resoueceName = resoueceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	
}
