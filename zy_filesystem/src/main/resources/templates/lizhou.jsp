<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>首页--物资管理系统</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<%@ include file="/WEB-INF/base/base.jsp" %>
	<link rel="stylesheet" href="${ctx }/static/css/public.css" media="all" />
</head>
<body class="childrenBody">

		<!-- 当前时间 -->
		<blockquote class="layui-elem-quote layui-bg-green">
			<div id="nowTime">亲爱的！<span class="layui-badge">${user.loginName }</span></div>
		</blockquote>
		
		<!-- 基本参数设置 -->
		<div class="layui-col-lg6 layui-col-md6">
			<blockquote class="layui-elem-quote title">项目基本参数</blockquote>
			<table class="layui-table magt0">
				<colgroup>
				    <col width="150">
				    <col width="200">
			  	</colgroup>
				<tbody>
					<tr>
						<td>当前版本</td>
						<td class="version">1.2.1, 2.0, 5.0.0 build-13124</td>
					</tr>
					<tr>
						<td>开发作者</td>
						<td class="author">Michael Scofield</td>
					</tr>
					<tr>
						<td>网站首页</td>
						<td class="homePage">http://localhost:8080/goods/index</td>
					</tr>
					<tr>
						<td>服务器环境</td>
						<td class="server">Apache-Tomcat-8.5.33</td>
					</tr>
					<tr>
						<td>系统语言</td>
						<td class="systemLanguage">中文 (zh_CN)</td>
					</tr>
					<tr>
						<td>数据库版本</td>
						<td class="dataBase">MySQL Server 5.6</td>
					</tr>
					<tr>
						<td>最大上传限制</td>
						<td class="maxUpload">3M</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<!-- 系统基本参数 -->
		<div class="layui-col-lg6 layui-col-md6">
			<blockquote class="layui-elem-quote title">系统基本参数</blockquote>
			<table class="layui-table magt0">
				<colgroup>
				    <col width="150">
				    <col width="200">
			  	</colgroup>
				<tbody>
					<tr>
						<td>传输协议</td>
						<td class="protocol">${system.protocol }</td>
					</tr>
					<tr>
						<td>请求方式</td>
						<td class="requestMethod">${system.requestMethod }</td>
					</tr>
					<tr>
						<td>请求路径</td>
						<td class="requestUrl">${system.requestUrl }</td>
					</tr>
					<tr>
						<td>客户主机IP</td>
						<td class="remoteAddr">${system.remoteAddr }</td>
					</tr>
					<tr>
						<td>客户主机名</td>
						<td class="remoteHost">${system.remoteHost }</td>
					</tr>
					<tr>
						<td>操作系统</td>
						<td class="osName">${system.osName }</td>
					</tr>
					<tr>
						<td>浏览器类型</td>
						<td class="channelType">${system.channelType }</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<!-- 登陆记录 -->
		<div class="layui-col-lg6 layui-col-md6">
			<blockquote class="layui-elem-quote title">登录日志</blockquote>
			<table class="layui-table magt0" id="loginLogTable" style="margin: 0px;"></table>
		</div>
	
		<!-- 项目历程 -->
		<div class="layui-col-lg6 layui-col-md6">
			<blockquote class="layui-elem-quote title">项目历程</blockquote>
			<ul class="layui-timeline" style="max-height: 515px;overflow: auto;margin-top: 10px;">
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <h3 class="layui-timeline-title">8月18日</h3>
			      <p>
			        layui 2.0 的一切准备工作似乎都已到位。发布之弦，一触即发。
			        <br>不枉近百个日日夜夜与之为伴。因小而大，因弱而强。
			        <br>无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔 <i class="layui-icon"></i>
			      </p>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <h3 class="layui-timeline-title">8月16日</h3>
			      <p>杜甫的思想核心是儒家的仁政思想，他有“<em>致君尧舜上，再使风俗淳</em>”的宏伟抱负。个人最爱的名篇有：</p>
			      <ul>
			        <li>《登高》</li>
			        <li>《茅屋为秋风所破歌》</li>
			      </ul>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <h3 class="layui-timeline-title">8月15日</h3>
			      <p> 中国人民抗日战争胜利72周年
			        <br>常常在想，尽管对这个国家有这样那样的抱怨，但我们的确生在了最好的时代
			        <br>铭记、感恩
			        <br>所有为中华民族浴血奋战的英雄将士
			        <br>永垂不朽
			      </p>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <div class="layui-timeline-title">过去</div>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <h3 class="layui-timeline-title">8月18日</h3>
			      <p>
			        layui 2.0 的一切准备工作似乎都已到位。发布之弦，一触即发。
			        <br>不枉近百个日日夜夜与之为伴。因小而大，因弱而强。
			        <br>无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔 <i class="layui-icon"></i>
			      </p>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <h3 class="layui-timeline-title">8月16日</h3>
			      <p>杜甫的思想核心是儒家的仁政思想，他有“<em>致君尧舜上，再使风俗淳</em>”的宏伟抱负。个人最爱的名篇有：</p>
			      <ul>
			        <li>《登高》</li>
			        <li>《茅屋为秋风所破歌》</li>
			      </ul>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <h3 class="layui-timeline-title">8月15日</h3>
			      <p> 中国人民抗日战争胜利72周年
			        <br>常常在想，尽管对这个国家有这样那样的抱怨，但我们的确生在了最好的时代
			        <br>铭记、感恩
			        <br>所有为中华民族浴血奋战的英雄将士
			        <br>永垂不朽
			      </p>
			    </div>
			  </li>
			  <li class="layui-timeline-item">
			    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
			    <div class="layui-timeline-content layui-text">
			      <div class="layui-timeline-title">过去</div>
			    </div>
			  </li>
			</ul>
		</div>
		
	<script type="text/javascript" src="${ctx }/static/js/main.js"></script>
	<%@ include file="/WEB-INF/base/progress.jsp" %>
</body>
</html>