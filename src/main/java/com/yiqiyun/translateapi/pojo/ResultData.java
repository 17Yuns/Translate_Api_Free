package com.yiqiyun.translateapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 17Yuns
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResultData {
    int code;
    String data;
    String pinyin;
    String[] alternatives;
}
