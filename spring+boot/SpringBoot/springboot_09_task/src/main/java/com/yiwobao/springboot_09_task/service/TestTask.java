package com.yiwobao.springboot_09_task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //每隔5秒执行一次
    //@Scheduled(cron = "*/5 * * * * ?")
    // @Scheduled( fixedRate = 3000)
    public void schedulerOutPutTask() {
        System.out.println(simpleDateFormat.format(new Date()));
    }

    private String username="root";//数据库用户名

    private String password="zhou";//数据库用户密码

    private String dbname="world";//备份数据库名

    private String path="c:\\mysql\\";//备份文件存储路径

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {

        File file = new File(path);
        if(!file.exists()){
            file.mkdir();//如果不存在就创建文件夹
        }
        //获取当前时间
        String currentDate=simpleDateFormat.format(new Date());

        //数据库备份命令,使用当前时间+数据库名命名以防文件名重复出错
        /**
         * 注意 如果mysqldump.exe所在的文件夹有空格  比如 program Files  那么执行下面的备份命令可以成功但是备份的文件内容为空
         * 所以为了测试 我把mysql bin 目录下的mysqldump.exe 拿到C盘下 避免空格
         */
        String cmd="cmd /C c:\\mysqldump -u{0} -p{1} {2} > {3}{4}_{5}.sql";
        cmd=MessageFormat.format(cmd,username,password,dbname,path,
                currentDate.replaceAll("-","")
                        .replaceAll(" ","")
                        .replaceAll(":",""),dbname);

        try {
            /*执行命令*/
            Process process = Runtime.getRuntime().exec(cmd);
            if(process.waitFor()==0){
                System.err.println(currentDate+"备份数据库成功");
            }
        } catch (Exception e) {
            System.err.println(currentDate+"备份数据库失败,报错:"+e.getMessage());
            e.printStackTrace();
        }
    }




}
