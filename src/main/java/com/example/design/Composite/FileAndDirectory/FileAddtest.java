package com.example.design.Composite.FileAndDirectory;

/**
 * @author zhaoyansheng
 * @package com.example.design.Composite.FileAndDirectory
 * @date 2020/9/3
 * @description 描述
 */
public class FileAddtest {
    public static void main(String[] args) {
        File  diary = new File("diary.html", 100);
        try {
            diary.add(new File("diary.html1", 100));
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

    }
}
