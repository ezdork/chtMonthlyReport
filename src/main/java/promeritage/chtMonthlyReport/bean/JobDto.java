package promeritage.chtMonthlyReport.bean;


public class JobDto {

    private int workNum = 1;
    private int num = 1;
    private int total = 1;
    private boolean workOverTime = false; // 是否為加班
    private String startDate;
    private String endDate;
    private String workContent;
    
    // 報表用
    private String week;
    private String remark; 
    private String formatWorkContent;
    private String myName;
    private String masterName;
    
    public JobDto(){
        
    }
    
    public JobDto(String startDate, String week, String workContent, String remark) {
        this.startDate = startDate;
        this.week = week;
        this.workContent = workContent;
        this.remark = remark;
        
        this.endDate = startDate;
    }
    
    public boolean isWorkOverTime() {
        return workOverTime;
    }
    public void setWorkOverTime(boolean workOverTime) {
        this.workOverTime = workOverTime;
    }
    public String getMyName() {
        return myName;
    }
    public void setMyName(String myName) {
        this.myName = myName;
    }
    public String getMasterName() {
        return masterName;
    }
    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
    public int getWorkNum() {
        return workNum;
    }
    public void setWorkNum(int workNum) {
        this.workNum = workNum;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getFormatWorkContent() {
        return formatWorkContent;
    }
    public void setFormatWorkContent(String formatWorkContent) {
        this.formatWorkContent = formatWorkContent;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getWeek() {
        return week;
    }
    public void setWeek(String week) {
        this.week = week;
    }
    public String getWorkContent() {
        return workContent;
    }
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CustomBean [workNum=" + workNum + ", num=" + num + ", total=" + total + ", endDate=" + endDate + ", workContent=" + workContent + ", startDate=" + startDate + ", week=" + week + ", remark=" + remark + ", formatWorkContent=" + formatWorkContent + "]";
    }

}