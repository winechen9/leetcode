public class Read_N_Characters_Given_Read4_157 {
    /*
    就是看最后读了几个文件，如果有余数的部分，是不会计算在内的
     */
    int read4(char[] buf){
        return 0;
    }
    public int read(char[] buf, int n){
        boolean eof = false;
        int total = 0;
        char[] tmp = new char[4];

        while (!eof && total < n){
            int count = read4(tmp);

            eof = count < 4;

            count = Math.min(count, n - total);

            for (int i = 0; i < count; i++){
                buf[total++] = tmp[i];
            }
        }


        return total;
    }
}
