class Solution {
    

    public String convertToTitle(int columnNumber) {
        if(columnNumber<=0) return "";
        columnNumber --;
        char  ch=(char)('A'+(columnNumber%26));
        
        return convertToTitle(columnNumber/26)+ch;
    }
    
}