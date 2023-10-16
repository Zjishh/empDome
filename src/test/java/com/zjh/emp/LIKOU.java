package com.zjh.emp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/****************************
 * @project empservice
 * @package com.zjh.emp
 * @className LIKOU
 * @author Zjiah
 * @date 2023/10/13 17:17
 * @Description:   *
 ****************************/
@SpringBootTest
public class LIKOU {


    @Test
    public long t() {
        int[] nums = {1, 2, 3, 4, 5};
        StringBuffer stringBuffer = new StringBuffer();
        long a = 0;
        long sum = 0;
        if (nums.length % 2 != 0) {
            a = nums[(nums.length - 1) / 2];
            for (int i = 0; i < nums.length; i++) {
                stringBuffer.append(nums[i]);
                stringBuffer.append(nums[nums.length - i - 1]);
                long l = Long.parseLong(stringBuffer.toString());
                sum+=l;

            }
            sum+=a;
        } else {
            for (int i = 0; i < nums.length; i++) {
                stringBuffer.append(nums[i]);
                stringBuffer.append(nums[nums.length - i - 1]);
                long l = Long.parseLong(stringBuffer.toString());
                sum+=l;

            }
        }
            return sum;
    }

}
