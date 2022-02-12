class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:wordList){
            for(int i=0;i<s.length();i++){
                String pattern=s.substring(0,i)+"*"+s.substring(i+1);
                if(map.containsKey(pattern)){
                    map.get(pattern).add(s);
                }else{
                    ArrayList<String> arr=new ArrayList();
                    arr.add(s);
                    map.put(pattern,arr);
                }
            }
        }
        HashSet<String> visited=new HashSet<>();
        
        return bfs(map,visited,beginWord,endWord);
    }
    
    int bfs(HashMap<String,ArrayList<String>> map,HashSet<String> visited,String src,String target){
        Queue<String> q=new LinkedList<>();
        q.add(src);
        visited.add(src);;
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                String rStr = q.poll();
                if(rStr.equals(target))return ans;
                for(int i=0;i<rStr.length();i++){
                    String pattern=rStr.substring(0,i)+"*"+rStr.substring(i+1);
                    for(String node:map.getOrDefault(pattern,new ArrayList<>())){
                        if(!visited.contains(node)){
                            q.add(node);        
                            visited.add(node);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
