package com.yiqiyun.translateapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 17Yuns
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {
    String text;
    String target_lang;
    String source_lang;
}
