package coding;

import java.util.*;

public class WebPagination {
    public static void main(String args[]) {
        int size=3;
        int attr_count=3;
        List<List<String>> items = new ArrayList<List<String>>();
        int sortParameter=1;
        int sortOrder=0;
        int itemPerPage=2;
        int pageNumber=1;
        List<String> item1 = Arrays.asList(new String[]{"item1","10","15"});
        List<String> item2 = Arrays.asList(new String[]{"item2","3","4"});
        List<String> item3 = Arrays.asList(new String[]{"item3","17","8"});
        items.add(item1);
        items.add(item2);
        items.add(item3);
        
        WebPagination c=new WebPagination();
        List<String> result = c.helper(items, sortParameter, sortOrder, itemPerPage, pageNumber);
        System.out.println("size: "+result.size());
        for(String x: result){
            System.out.println("x: "+x);
        }
    }
    
    public List<String> helper(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber){
        List<String> res=new ArrayList<String>();
        
        CustomComparator c1 = new CustomComparator(sortOrder,sortParameter);
        Collections.sort(items, c1);
        
        int itemsOnOnePage = items.size()/itemPerPage;
        int page=0;
        
        HashMap<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        for(int i=0;i<items.size();i++){
            int itemNo = itemsOnOnePage;
            List<List<String>> tuple = new ArrayList<List<String>>();
            while(itemNo>0){
                tuple.add(items.get(i));
                System.out.println("it: "+items.get(i).get(0));
                itemNo--;
            }
            map.put(page++,tuple);
        }
        for(List<String> x: map.get(pageNumber)){
            res.add(x.get(0));
        }
        return res;
    }
    
    public class CustomComparator implements Comparator<List<String>>{
    private int order = 0;
    private int sortParameter = 0;

    public CustomComparator(int order, int sortParameter) {
        this.order = order;
        this.sortParameter = sortParameter;
    }

    public int compare(List<String> entry1, List<String> entry2) {
        
        String obj1 = entry1.get(sortParameter);
        String obj2 = entry2.get(sortParameter);
            if(order==0){
                 obj1 = entry1.get(sortParameter);
                 obj2 = entry2.get(sortParameter);
            }
            else{
                  obj2 = entry1.get(sortParameter);
                  obj1 = entry2.get(sortParameter);
                } 
                if (obj1 == obj2) {
                   return 0;
               }
        if (obj1 == null) {
           return -1;
        }
        if (obj2 == null) {
           return 1;
        }

        return obj1.compareTo(obj2);
    }
}
}

