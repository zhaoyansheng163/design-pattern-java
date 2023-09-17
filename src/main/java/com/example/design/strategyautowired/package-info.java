/**
 * @author zhaoyansheng
 * @package com.example.design.strategy
 * @date 2020/6/29
 * @description 描述
 */
package com.example.design.strategyautowired;
//参考  https://blog.csdn.net/qq_28056571/article/details/90139693
//源码：https://github.com/919337588/springboot_strategy

//测试方式：http://127.0.0.1:8080/toPayAutoWHtml?payCode=aliPayAutoWStrategy
//  http://127.0.0.1:8080/toPayAutoWHtml?payCode=yinLianAutoWPayStrategy

//添加bean name之后
//测试方式：http://127.0.0.1:8080/toPayAutoWHtml?payCode=aa
//  http://127.0.0.1:8080/toPayAutoWHtml?payCode=yy

// 对于那种paycode的枚举值已经是确定的，不能更改，例如存量系统01表示支付宝 02表示银联
// 因为01 02不能作为componetnt的beanname，因此可以通过增加一个支付类型的枚举类，把01翻译成alipay，通过01获取beanname时，转换一下即可