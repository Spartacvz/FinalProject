package com.Greg;

import java.io.Serializable;
import java.util.Date;

public class Tasks {
    String task_num;
    String task_name;
    String task_description;
    Date entry_date;
    String due_date;
    String task_complete;

    public Tasks(String task_Num, String task_Name, String task_Description, String due_Date, Date entry_Date, String task_Complete)    {
        this.task_num = task_Num;
        this.task_name = task_Name;
        this.task_description = task_Description;
        this.entry_date = entry_Date;
        this.due_date = due_Date;
        this.task_complete = task_Complete;
    }

    public String getTaskNum()    {
        return task_num;
    }
    public String getTaskName()    {
        return task_name;
    }
    public String getTaskDescription()    {
        return task_description;
    }
    public Date getEntryDate()    {
        return entry_date;
    }
    public String getDueDate()    {
        return due_date;
    }
    public String getTaskComplete()    {
        return task_complete;
    }

}
