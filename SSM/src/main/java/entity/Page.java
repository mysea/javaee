package entity;

import lombok.Data;

/*
* 存放分页信息
* */
@Data
public class Page {
    //起始页
    int start = 0;
    //最后一页
    int last = 0;
    //每页的数据条数
    int count = 5;

    public void caculateLast(int total){
        if (total % count == 0) {//刚好是count的倍数，最后一页就是count条数据
            last = total - count;
        }else {//不能被整除，最后一页数据就是多出来的那几条数据
            last = total - total % count;
        }
    }
}
