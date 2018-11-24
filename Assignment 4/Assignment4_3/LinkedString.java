/*
name: Woohyeon Baek
student number: 2017-15782
 */

public class LinkedString implements LinkedStringInterface {
    private charNode front;
    private charNode rear;

    public LinkedString(String str) {
        //This will be frequently used.
        this(str.toCharArray());
    }

    public LinkedString(char[] arr) {
        //You can also use this.
        for(int i = 0; i < arr.length; i++)
            pushBack(arr[i]);
    }

    public LinkedString() { }

    private void pushBack(char ch) {
        if(rear == null) {
            front = rear = new charNode();
            rear.ch = ch;
        }
        else {
            rear.next = new charNode();
            rear = rear.next;
            rear.ch = ch;
        }
    }

    public void remove(String substr) {
        int start, length = substr.length();
        while((start = indexOf(substr)) != -1) {
            charNode right = front;
            for(int i = 0; i < start + length; i++)
                right = right.next;
            if(start > 0) {
                charNode left = front;
                for(int i = 0; i < start - 1; i++)
                    left = left.next;
                left.next = right;
            }
            else front = right;
        }
    }

    public void remove(LinkedStringInterface substr) { remove(substr.toString()); }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(charNode curr = front; curr != null; curr = curr.next)
            str.append(curr.ch);
        return str.toString();
    }

    public char charAt(int index) {
        if(index < 0 || index >= length())
            throw new IndexOutOfBoundsException();
        charNode curr = front;
        for(int i = 0; i < index; i++)
            curr = curr.next;
        return curr.ch;
    }

    public int length() {
        int length = 0;
        for(charNode curr = front; curr != null; curr = curr.next)
            length++;
        return length;
    }

    public LinkedStringInterface substring(int startIndex, int endIndex) {
        int length = length();
        if(startIndex < 0 || endIndex > length || startIndex > endIndex)
            throw new IndexOutOfBoundsException();
        StringBuilder str = new StringBuilder();
        charNode curr = front;
        for(int i = 0; i < endIndex; i++) {
            if(i >= startIndex)
                str.append(curr.ch);
            curr = curr.next;
        }
        return new LinkedString(str.toString());
    }

    public boolean contains(LinkedStringInterface substr) { return contains(substr.toString()); }

    public boolean contains(String substr) { return indexOf(substr) != -1; }

    public int compareTo(LinkedStringInterface str) { return compareTo(str.toString()); }

    public int compareTo(String str) {
        int length = str.length();
        charNode curr = front;
        for(int i = 0; i < length && curr != null; i++, curr = curr.next)
            if(curr.ch != str.charAt(i))
                return curr.ch - str.charAt(i);
        return length() - length;
    }

    public int compareToIgnoreCase(LinkedStringInterface str) { return compareToIgnoreCase(str.toString()); }

    public int compareToIgnoreCase(String str) {
        LinkedString str2 = new LinkedString();
        for(charNode curr = front; curr != null; curr = curr.next)
            str2.pushBack(Character.toLowerCase(Character.toUpperCase(curr.ch)));
        StringBuilder str3 = new StringBuilder();
        int length = str.length();
        for(int i = 0; i < length; i++)
                str3.append(Character.toLowerCase(Character.toUpperCase(str.charAt(i))));
        return str2.compareTo(str3.toString());
    }

    public LinkedStringInterface concat(LinkedStringInterface str) { return concat(str.toString()); }

    public LinkedStringInterface concat(String str) {
        LinkedString str2 = new LinkedString();
        for(charNode curr = front; curr != null; curr = curr.next)
            str2.pushBack(curr.ch);
        int length = str.length();
        for(int i = 0; i < length; i++)
            str2.pushBack(str.charAt(i));
        return str2;
    }

    public int indexOf(char ch) { return indexOf("" + ch); };

    public int indexOf(String str) {
        int length = length(), strLength = str.length();
        charNode start = front;
        for(int i = 0; i < length - strLength + 1; i++) {
            LinkedString str2 = new LinkedString();
            charNode curr = start;
            for(int j = 0; j < strLength; j++) {
                str2.pushBack(curr.ch);
                curr = curr.next;
            }
            if(str2.compareTo(str) == 0) return i;
            start = start.next;
        }
        return -1;
    }

    public LinkedStringInterface replace(char oldChar, char newChar) {
        LinkedString str = new LinkedString();
        for(charNode curr = front; curr != null; curr = curr.next) {
            if(curr.ch == oldChar)
                str.pushBack(newChar);
            else
                str.pushBack(curr.ch);
        }
        return str;
    }
}
