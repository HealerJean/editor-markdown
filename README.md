---
title: SpringBoot编辑Markdown
date: 2018-07-19 03:33:00
tags: 
- SpringBoot
category: 
- SpringBoot
description: SpringBoot编辑Markdown
---
<!-- image url 
https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/blogImages
　　首行缩进
<font color="red">  </font>
-->

## 前言

> Markdown是一种可以使用普通文本编辑器编写的标记语言，通过简单的标记语法，它可以使普通文本内容具有一定的格式。

## 前言
[Editor.md](https://github.com/pandao/editor.md) 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。本章将使用`SpringBoot`整合`Editor.md`构建Markdown编辑器。

### 下载插件

项目地址：[Editor.md](https://github.com/pandao/editor.md)


### 配置Editor.md

将exapmles文件夹中的simple.html放置到项目中，并配置对应的css和js文件

#### 配置编辑器

```html
......
	<script src="${re.contextPath}/jquery.min.js"></script>
    <script src="${re.contextPath}/editor/editormd.min.js"></script>
    <link rel="stylesheet" href="${re.contextPath}/editor/css/style.css"/>
    <link rel="stylesheet" href="${re.contextPath}/editor/css/editormd.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
......
<!-- 存放源文件用于编辑 -->
 <textarea style="display:none;" id="textContent" name="textContent">
</textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea id="text" class="editormd-html-textarea" name="text"></textarea>
    </div>
```

#### 初始化编辑器


```javascript
var testEditor;

    $(function () {
        testEditor = editormd("test-editormd", {
            width: "90%",
            height: 640,
            syncScrolling: "single",
            path: "${re.contextPath}/editor/lib/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/file",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true
            // previewTheme : "dark"
        });
    });
```



- 访问地址：[http://localhost:8080/](http://localhost:8080/)


### 文件预览

表单POST提交时，editor.md将我们的markdown语法文档翻译成了HTML语言，并将html字符串提交给了我们的后台，后台将这些HTML字符串持久化到数据库中。具体在页面显示做法如下：

```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Editor.md examples</title>
    <link rel="stylesheet" href="${re.contextPath}/editor/css/editormd.preview.min.css" />
    <link rel="stylesheet" href="${re.contextPath}/editor/css/editormd.css"/>
</head>
<body>
<!-- 因为我们使用了dark主题，所以在容器div上加上dark的主题类，实现我们自定义的代码样式 -->
<div class="content editormd-preview-theme" id="content">${editor.content!''}</div>
<script src="${re.contextPath}/jquery.min.js"></script>
<script src="${re.contextPath}/editor/lib/marked.min.js"></script>
<script src="${re.contextPath}/editor/lib/prettify.min.js"></script>
<script src="${re.contextPath}/editor/editormd.min.js"></script>
<script type="text/javascript">
    editormd.markdownToHTML("content");
</script>
</body>
</html>
```


## [代码下载](https://github.com/HealerJean123/editor-markdown.git)









<br/><br/><br/>
如果满意，请打赏博主任意金额，感兴趣的在微信转账的时候，添加博主微信哦， 请下方留言吧。可与博主自由讨论哦

|支付包 | 微信|微信公众号|
|:-------:|:-------:|:------:|
|![支付宝](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/assets/img/tctip/alpay.jpg) | ![微信](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/assets/img/tctip/weixin.jpg)|![微信公众号](https://raw.githubusercontent.com/HealerJean123/HealerJean123.github.io/master/assets/img/my/qrcode_for_gh_a23c07a2da9e_258.jpg)|




<!-- Gitalk 评论 start  -->

<link rel="stylesheet" href="https://unpkg.com/gitalk/dist/gitalk.css">
<script src="https://unpkg.com/gitalk@latest/dist/gitalk.min.js"></script> 
<div id="gitalk-container"></div>    
 <script type="text/javascript">
    var gitalk = new Gitalk({
		clientID: `1d164cd85549874d0e3a`,
		clientSecret: `527c3d223d1e6608953e835b547061037d140355`,
		repo: `HealerJean123.github.io`,
		owner: 'HealerJean123',
		admin: ['HealerJean123'],
		id: '7dhf6mT8VlXWBwpv',
    });
    gitalk.render('gitalk-container');
</script> 

<!-- Gitalk end -->

