import java.util.*;
public class Encode_and_Decode_TinyURL_535 {
    /*
    可以各种freestyle，用计数是最简单的，直接就可以在list中找到这个url在第几个，直接取出来就好了。
    如果是常规的那种6位随机数的话，也是很直观的，用一个长短url的map来存两者的关系就是了，用随机生成的key string作为key
    随机数就从charSet中随机取6位
     */
    Random r = new Random();
    Map<Integer, String> map = new HashMap<>();
    int key = r.nextInt(Integer.MAX_VALUE);
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(map.containsKey(key)){
            key = r.nextInt(Integer.MAX_VALUE);//直到找到没有用过的key
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.valueOf(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
