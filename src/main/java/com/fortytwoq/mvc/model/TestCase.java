package com.fortytwoq.mvc.model;

import java.util.Date;
import java.util.List;

public class TestCase {
    private Integer id;

    private String testCaseId;

    private Integer testModuleId;

    private String caseName;

    private String menuModuleValue;

    private String menuFunctionValue;

    private String classModuleName;

    private String classFunctionName;

    private Integer enable;

    private Date createDate;

    private Date updateDate;
    
    private List<TestCaseStep> testCaseSteps;
    

    public List<TestCaseStep> getTestCaseSteps() {
		return testCaseSteps;
	}

	public void setTestCaseSteps(List<TestCaseStep> testCaseSteps) {
		this.testCaseSteps = testCaseSteps;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId == null ? null : testCaseId.trim();
    }

    public Integer getTestModuleId() {
        return testModuleId;
    }

    public void setTestModuleId(Integer testModuleId) {
        this.testModuleId = testModuleId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }
    
    public String getMenuModuleValue() {
        return menuModuleValue;
    }

    public void setMenuModuleValue(String menuModuleValue) {
        this.menuModuleValue = menuModuleValue == null ? null : menuModuleValue.trim();
    }

    public String getMenuFunctionValue() {
        return menuFunctionValue;
    }

    public void setMenuFunctionValue(String menuFunctionValue) {
        this.menuFunctionValue = menuFunctionValue == null ? null : menuFunctionValue.trim();
    }

    public String getClassModuleName() {
        return classModuleName;
    }

    public void setClassModuleName(String classModuleName) {
        this.classModuleName = classModuleName == null ? null : classModuleName.trim();
    }

    public String getClassFunctionName() {
        return classFunctionName;
    }

    public void setClassFunctionName(String classFunctionName) {
        this.classFunctionName = classFunctionName == null ? null : classFunctionName.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TestCase other = (TestCase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTestCaseId() == null ? other.getTestCaseId() == null : this.getTestCaseId().equals(other.getTestCaseId()))
            && (this.getTestModuleId() == null ? other.getTestModuleId() == null : this.getTestModuleId().equals(other.getTestModuleId()))
            && (this.getCaseName() == null ? other.getCaseName() == null : this.getCaseName().equals(other.getCaseName()))
            && (this.getMenuModuleValue() == null ? other.getMenuModuleValue() == null : this.getMenuModuleValue().equals(other.getMenuModuleValue()))
            && (this.getMenuFunctionValue() == null ? other.getMenuFunctionValue() == null : this.getMenuFunctionValue().equals(other.getMenuFunctionValue()))
            && (this.getClassModuleName() == null ? other.getClassModuleName() == null : this.getClassModuleName().equals(other.getClassModuleName()))
            && (this.getClassFunctionName() == null ? other.getClassFunctionName() == null : this.getClassFunctionName().equals(other.getClassFunctionName()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTestCaseId() == null) ? 0 : getTestCaseId().hashCode());
        result = prime * result + ((getTestModuleId() == null) ? 0 : getTestModuleId().hashCode());
        result = prime * result + ((getCaseName() == null) ? 0 : getCaseName().hashCode());
        result = prime * result + ((getMenuModuleValue() == null) ? 0 : getMenuModuleValue().hashCode());
        result = prime * result + ((getMenuFunctionValue() == null) ? 0 : getMenuFunctionValue().hashCode());
        result = prime * result + ((getClassModuleName() == null) ? 0 : getClassModuleName().hashCode());
        result = prime * result + ((getClassFunctionName() == null) ? 0 : getClassFunctionName().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "TestCase [id=" + id + ", testCaseId=" + testCaseId + ", testModuleId=" + testModuleId + ", caseName="
				+ caseName + ", menuModuleValue=" + menuModuleValue + ", menuFunctionValue=" + menuFunctionValue
				+ ", classModuleName=" + classModuleName + ", classFunctionName=" + classFunctionName + ", enable="
				+ enable + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
    
}