# 项目简述
<h4>前后端分离项目，本人负责后端接口开发 <br> 后端使用技术栈：springboot+mybatis+MySQL </h4>
<p>HR登录部分：使用MD5加密工具加密密码，从数据库中查找账号信息，判不为空后生成使用UUID生成token保存到数据库并返回给前端做登录验证。</p>
<p>员工分页查询部分：在业务层处理页码和页面条数参数，将处理完的参数传递到dao层，dao层根据需求对员工表和部门进行联合查询，并根据分页要求使用mybatis做mysql语句LIMIT查询。</p>
<p>员工条件查询部分：根据取得的参数，使用&lt;where&gt;和&lt;if&gt;标签拼接mysql语句做数据库查询操作。</p>
<p>员工删除部分：使用&lt;foreach&gt;标签遍历参数做数据库delete操作。</p>

# 项目运行

<li>在sql中运行数据库文件</li>
<p></p>
<li>在application.yml中配置数据库信息</li>
<P></P>
<li>使用postman或前端测试controller</li>

# 前端部分

<li>解压前端部分</li>
<p></p>
<li>在目录地址运行cmd，使用start nginx运行前端部分</li>
<P></P>
<li>打开浏览器进入http://localhost:8800/进入登录页面</li>
<p></p>
<li>用户名 admin</li>
<li>密码  admin</li>
