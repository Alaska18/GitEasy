package giteasy;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Thread.sleep;

public class GitEasy implements Runnable  {


    public static void main(String[] args) {
        System.out.println("Searching for Git Repository ...");
        try
        {
            startSearching();
        }
        catch (InterruptedException i)
        {
            System.out.println("Exception caught!: " + i.getMessage());
        }

    }
    private static void startSearching() throws InterruptedException
    {
        sleep(3000);
        Thread searchingThread = new Thread(new GitEasy());

        try {
            searchingThread.start();
        } catch (NullPointerException n) {
            System.out.println("Null Pointer Exception caught!: " + n.getMessage());
        }
    }
    @Override
    public void run() throws NullPointerException
    {
        String dir = System.getProperty("user.dir");
        String workingDir = "";
        for (int i = dir.length() - 1; i >= 0; i--)
        {
            if (dir.charAt(i) == '/')
            {
                workingDir = dir.substring(i + 1, dir.length());
                break;
            }
        }
        System.out.println("Working Directory is " + workingDir);
        File file = new File(".");
        File[] list = file.listFiles();
        boolean flag = false;
        for (int i = 0; i < list.length; i++)
        {
            String nameOfFile = list[i].getName();
            if (nameOfFile.equals(".git"))
            {
                System.out.println("Working Git Repository found in the working directory.");
                flag = true;
                break;
            }
        }
        if (!flag)
        {
            System.out.println("No Git Repository found.");
        }
    }
}