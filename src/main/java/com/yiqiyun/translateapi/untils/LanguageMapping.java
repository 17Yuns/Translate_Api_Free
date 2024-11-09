package com.yiqiyun.translateapi.untils;

import java.util.HashMap;
import java.util.Map;


/**
 * 语言映射工具类
 * 用于将输入的目标语言映射到 Google 和 Bing 翻译 API 使用的语言代码
 *
 * @author 17Yuns
 */

public class LanguageMapping {

    // Google 和 Bing 的语言映射
    private static final Map<String, String> googleLangMap = new HashMap<>();
    private static final Map<String, String> bingLangMap = new HashMap<>();

    static {
        // Google 翻译支持的语言映射
        googleLangMap.put("sq", "sq"); // 阿尔巴尼亚语
        googleLangMap.put("ar", "ar"); // 阿拉伯语
        googleLangMap.put("am", "am"); // 阿姆哈拉语
        googleLangMap.put("az", "az"); // 阿塞拜疆语
        googleLangMap.put("ga", "ga"); // 爱尔兰语
        googleLangMap.put("et", "et"); // 爱沙尼亚语
        googleLangMap.put("eu", "eu"); // 巴斯克语
        googleLangMap.put("be", "be"); // 白俄罗斯语
        googleLangMap.put("bg", "bg"); // 保加利亚语
        googleLangMap.put("is", "is"); // 冰岛语
        googleLangMap.put("pl", "pl"); // 波兰语
        googleLangMap.put("bs", "bs"); // 波斯尼亚语
        googleLangMap.put("fa", "fa"); // 波斯语
        googleLangMap.put("af", "af"); // 布尔语(南非荷兰语)
        googleLangMap.put("da", "da"); // 丹麦语
        googleLangMap.put("de", "de"); // 德语
        googleLangMap.put("ru", "ru"); // 俄语
        googleLangMap.put("fr", "fr"); // 法语
        googleLangMap.put("tl", "tl"); // 菲律宾语
        googleLangMap.put("fi", "fi"); // 芬兰语
        googleLangMap.put("fy", "fy"); // 弗里西语
        googleLangMap.put("km", "km"); // 高棉语
        googleLangMap.put("ka", "ka"); // 格鲁吉亚语
        googleLangMap.put("gu", "gu"); // 古吉拉特语
        googleLangMap.put("kk", "kk"); // 哈萨克语
        googleLangMap.put("ht", "ht"); // 海地克里奥尔语
        googleLangMap.put("ko", "ko"); // 韩语
        googleLangMap.put("ha", "ha"); // 豪萨语
        googleLangMap.put("nl", "nl"); // 荷兰语
        googleLangMap.put("ky", "ky"); // 吉尔吉斯语
        googleLangMap.put("gl", "gl"); // 加利西亚语
        googleLangMap.put("ca", "ca"); // 加泰罗尼亚语
        googleLangMap.put("cs", "cs"); // 捷克语
        googleLangMap.put("kn", "kn"); // 卡纳达语
        googleLangMap.put("co", "co"); // 科西嘉语
        googleLangMap.put("hr", "hr"); // 克罗地亚语
        googleLangMap.put("ku", "ku"); // 库尔德语
        googleLangMap.put("la", "la"); // 拉丁语
        googleLangMap.put("lv", "lv"); // 拉脱维亚语
        googleLangMap.put("lo", "lo"); // 老挝语
        googleLangMap.put("lt", "lt"); // 立陶宛语
        googleLangMap.put("lb", "lb"); // 卢森堡语
        googleLangMap.put("ro", "ro"); // 罗马尼亚语
        googleLangMap.put("mg", "mg"); // 马尔加什语
        googleLangMap.put("mt", "mt"); // 马耳他语
        googleLangMap.put("mr", "mr"); // 马拉地语
        googleLangMap.put("ml", "ml"); // 马拉雅拉姆语
        googleLangMap.put("ms", "ms"); // 马来语
        googleLangMap.put("mk", "mk"); // 马其顿语
        googleLangMap.put("mi", "mi"); // 毛利语
        googleLangMap.put("mn", "mn"); // 蒙古语
        googleLangMap.put("bn", "bn"); // 孟加拉语
        googleLangMap.put("my", "my"); // 缅甸语
        googleLangMap.put("hmn", "hmn"); // 苗语
        googleLangMap.put("xh", "xh"); // 南非科萨语
        googleLangMap.put("zu", "zu"); // 南非祖鲁语
        googleLangMap.put("ne", "ne"); // 尼泊尔语
        googleLangMap.put("no", "no"); // 挪威语
        googleLangMap.put("pa", "pa"); // 旁遮普语
        googleLangMap.put("pt", "pt"); // 葡萄牙语
        googleLangMap.put("ps", "ps"); // 普什图语
        googleLangMap.put("ny", "ny"); // 齐切瓦语
        googleLangMap.put("ja", "ja"); // 日语
        googleLangMap.put("sv", "sv"); // 瑞典语
        googleLangMap.put("sm", "sm"); // 萨摩亚语
        googleLangMap.put("sr", "sr"); // 塞尔维亚语
        googleLangMap.put("st", "st"); // 塞索托语
        googleLangMap.put("sib", "sib"); // 僧伽罗语
        googleLangMap.put("eob", "eob"); // 世界语
        googleLangMap.put("skb", "skb"); // 斯洛伐克语
        googleLangMap.put("slb", "slb"); // 斯洛文尼亚语
        googleLangMap.put("swb", "swb"); // 斯瓦希里语
        googleLangMap.put("gdb", "gdb"); // 苏格兰盖尔语
        googleLangMap.put("ceb", "ceb"); // 宿务语
        googleLangMap.put("sob", "sob"); // 索马里语
        googleLangMap.put("tgb", "tgb"); // 塔吉克语
        googleLangMap.put("teb", "teb"); // 泰卢固语
        googleLangMap.put("tab", "tab"); // 泰米尔语
        googleLangMap.put("thb", "thb"); // 泰语
        googleLangMap.put("trb", "trb"); // 土耳其语
        googleLangMap.put("cyb", "cyb"); // 威尔士语
        googleLangMap.put("urb", "urb"); // 乌尔都语
        googleLangMap.put("ukb", "ukb"); // 乌克兰语
        googleLangMap.put("uzb", "uzb"); // 乌兹别克语
        googleLangMap.put("esb", "esb"); // 西班牙语
        googleLangMap.put("iwb", "iwb"); // 希伯来语
        googleLangMap.put("elb", "elb"); // 希腊语
        googleLangMap.put("habw", "habw"); // 夏威夷语
        googleLangMap.put("sdb", "sdb"); // 信德语
        googleLangMap.put("hub", "hub"); // 匈牙利语
        googleLangMap.put("snb", "snb"); // 修纳语
        googleLangMap.put("hyb", "hyb"); // 亚美尼亚语
        googleLangMap.put("igb", "igb"); // 伊博语
        googleLangMap.put("itb", "itb"); // 意大利语
        googleLangMap.put("yib", "yib"); // 意第绪语
        googleLangMap.put("hib", "hib"); // 印地语
        googleLangMap.put("sub", "sub"); // 印尼巽他语
        googleLangMap.put("idb", "idb"); // 印尼语
        googleLangMap.put("jwb", "jwb"); // 印尼爪哇语
        googleLangMap.put("en", "en"); // 英语
        googleLangMap.put("yob", "yob"); // 约鲁巴语
        googleLangMap.put("vib", "vib"); // 越南语
        googleLangMap.put("zh", "zh-CN"); //简体中文

        // Bing 翻译语言映射
        bingLangMap.put("ar", "ar"); // 阿拉伯语
        bingLangMap.put("et", "et"); // 爱沙尼亚语
        bingLangMap.put("bg", "bg"); // 保加利亚语
        bingLangMap.put("is", "is"); // 冰岛语
        bingLangMap.put("pl", "pl"); // 波兰语
        bingLangMap.put("bs-Latn", "bs-Latn"); // 波斯尼亚语
        bingLangMap.put("fa", "fa"); // 波斯语
        bingLangMap.put("da", "da"); // 丹麦语
        bingLangMap.put("de", "de"); // 德语
        bingLangMap.put("ru", "ru"); // 俄语
        bingLangMap.put("fr", "fr"); // 法语
        bingLangMap.put("zh-CHT", "zh-CHT"); // 繁体中文
        bingLangMap.put("fil", "fil"); // 菲律宾语
        bingLangMap.put("fj", "fj"); // 斐济语
        bingLangMap.put("fi", "fi"); // 芬兰语
        bingLangMap.put("ht", "ht"); // 海地克里奥尔语
        bingLangMap.put("ko", "ko"); // 韩语
        bingLangMap.put("nl", "nl"); // 荷兰语
        bingLangMap.put("ca", "ca"); // 加泰罗尼亚语
        bingLangMap.put("zh", "zh-Hans"); // 简体中文
        bingLangMap.put("cs", "cs"); // 捷克语
        bingLangMap.put("otq", "otq"); // 克雷塔罗奥托米语
        bingLangMap.put("tlh", "tlh"); // 克林贡语
        bingLangMap.put("tlh-Qaak", "tlh-Qaak"); // 克林贡语(plqaD)
        bingLangMap.put("hr", "hr"); // 克罗埃西亚语
        bingLangMap.put("lv", "lv"); // 拉脱维亚语
        bingLangMap.put("lt", "lt"); // 立陶宛语
        bingLangMap.put("ro", "ro"); // 罗马尼亚语
        bingLangMap.put("mg", "mg"); // 马达加斯加语
        bingLangMap.put("mt", "mt"); // 马耳他语
        bingLangMap.put("ms", "ms"); // 马来语
        bingLangMap.put("bn-BD", "bn-BD"); // 孟加拉语
        bingLangMap.put("mww", "mww"); // 苗语
        bingLangMap.put("af", "af"); // 南非荷兰语
        bingLangMap.put("no", "no"); // 挪威语
        bingLangMap.put("pt", "pt"); // 葡萄牙语
        bingLangMap.put("ja", "ja"); // 日语
        bingLangMap.put("sv", "sv"); // 瑞典语
        bingLangMap.put("sm", "sm"); // 萨摩亚语
        bingLangMap.put("sr-Latn", "sr-Latn"); // 塞尔维亚语(拉丁语)
        bingLangMap.put("sr-Cyrl", "sr-Cyrl"); // 塞尔维亚语(西里尔文)
        bingLangMap.put("sk", "sk"); // 斯洛伐克语
        bingLangMap.put("sl", "sl"); // 斯洛文尼亚语
        bingLangMap.put("sw", "sw"); // 斯瓦希里语
        bingLangMap.put("ty", "ty"); // 塔希提语
        bingLangMap.put("te", "te"); // 泰卢固语
        bingLangMap.put("ta", "ta"); // 泰米尔语
        bingLangMap.put("th", "th"); // 泰语
        bingLangMap.put("to", "to"); // 汤加语
        bingLangMap.put("tr", "tr"); // 土耳其语
        bingLangMap.put("cy", "cy"); // 威尔士语
        bingLangMap.put("ur", "ur"); // 乌尔都语
        bingLangMap.put("uk", "uk"); // 乌克兰语
        bingLangMap.put("es", "es"); // 西班牙语
        bingLangMap.put("he", "he"); // 希伯来语
        bingLangMap.put("el", "el"); // 希腊语
        bingLangMap.put("hu", "hu"); // 匈牙利语
        bingLangMap.put("it", "it"); // 意大利语
        bingLangMap.put("hi", "hi"); // 印地语
        bingLangMap.put("id", "id"); // 印度尼西亚语
        bingLangMap.put("en", "en"); // 英语
        bingLangMap.put("yua", "yua"); // 尤卡坦玛雅语
        bingLangMap.put("vi", "vi"); // 越南语
        bingLangMap.put("yue", "yue"); // 粤语(繁体)


    }

    /**
     * 根据传入的 targetLang 获取对应的 Google 语言代码
     *
     * @param targetLang 输入的目标语言
     * @return Google API 使用的语言代码
     */
    public static String getGoogleLang(String targetLang) {
        // 将 targetLang 转换为小写
        String langKey = targetLang.toLowerCase();
        return googleLangMap.getOrDefault(langKey, "en");
    }

    /**
     * 根据传入的 targetLang 获取对应的 Bing 语言代码
     *
     * @param targetLang 输入的目标语言
     * @return Bing API 使用的语言代码
     */
    public static String getBingLang(String targetLang) {
        // 将 targetLang 转换为小写
        String langKey = targetLang.toLowerCase();
        return bingLangMap.getOrDefault(langKey, "en");
    }
}

