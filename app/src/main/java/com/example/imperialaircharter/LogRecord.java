package com.example.imperialaircharter;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.imperialaircharter.DB.AppDatabase;

@Entity(tableName = AppDatabase.LOG_RECORDS_TABLE)
public class LogRecord {

    @PrimaryKey(autoGenerate = true)
    private int logId;
    private long time;
    private String transactionType;
    private String username;
    private String detailedMessage;


    public LogRecord() {

    }
    @Ignore
    public LogRecord(long time, String transactionType, String username, String detailedMessage) {
        this.time = time;
        this.transactionType = transactionType;
        this.username = username;
        this.detailedMessage = detailedMessage;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "time=" + time +
                ", transactionType='" + transactionType + '\'' +
                ", username='" + username + '\'' +
                ", detailedMessage='" + detailedMessage + '\'' +
                '}';
    }
}
