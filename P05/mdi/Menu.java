/*
Menu Manager Copyright (c) 2024 Professsor George F. Rice

Licensed under The MIT License (MIT)

Summary: Basically, you can do whatever you want as long as you include 
this copyright and license notice in any copy of the software/source.

Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included 
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION 
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package mdi;

import java.util.List;
import java.util.ArrayList;

// This class manages the entire menu and dispatch table
public class Menu {
    private List<MenuItem> items = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<items.size() ; ++i)
            sb.append(" " + i + "] " + items.get(i) + "\n");
       return sb.toString();
    }

    public void run(int itemNumber) {
        items.get(itemNumber).run();
    }

    public static String getString(String prompt, String cancelInput, String defaultInput) {
        String s = null;
        while (true) {
            try {
                System.out.print(prompt);
                s = System.console().readLine().trim(); // Adjusted to read user input
                if (s.isEmpty() && defaultInput != null) s = defaultInput;
                break;
            } catch (Exception e) {
                System.err.println("Invalid input!");
            }
        }
        if (cancelInput != null && s.equals(cancelInput)) s = null;
        return s;

    }

    public static String getString(String prompt, String cancelInput) {
        return getString(prompt, cancelInput, null);
    }

    public static String getString(String prompt) {
        return getString(prompt, null, null);
    }

    public static Integer getInt(String prompt, String cancelInput, String defaultInput) {
        Integer i = null;
        while (true) {
            try {
                String s = getString(prompt, cancelInput, defaultInput);
                if (s != null && !s.isEmpty()) i = Integer.parseInt(s);
                break;
            } catch (Exception e) {
                System.err.println("Invalid input!");
            }
        }
        return i;
    }

    public static Integer getInt(String prompt, String cancelInput) {
        return getInt(prompt, cancelInput, null);
    }

    public static Integer getInt(String prompt) {
        return getInt(prompt, null, null);
    }
}




