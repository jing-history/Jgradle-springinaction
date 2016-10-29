<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<di>
    <h2>Create a free Spitter account</h2>
    <!-- 标签的path 属性,它引用的是表单所绑定的Spitter对象属性 -->
    <sf:form method="post" modelAttribute="spitter">
        <fieleset>
            <table cellspacing="0">
                <tr>
                    <!-- for 属性规定 label 与哪个表单元素绑定。也就是点击文字也能用到标签-->
                    <th><sf:label path="fullName">Full name:</sf:label></th>
                    <td><sf:input path="fullName" size="15"/> </td>
                    <sf:errors path="fullName" delimiter=", " cssClass="error"/>
                </tr>
                <tr>
                    <th><sf:label path="username">Username:</sf:label></th>
                    <td><sf:input path="username" size="15" maxlength="15"/>
                        <small id="username_msg">No spaces,please.</small><br/>
                        <sf:errors path="username" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th><sf:label path="password">Password:</sf:label></th>
                    <td><sf:password path="password" size="30"
                                     showPassword="true"/>
                        <small>6 characters or more (be tricky!)</small><br/>
                        <sf:errors path="password" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th><sf:label path="email">Email Address:</sf:label></th>
                    <td><sf:input path="email" size="30"/>
                        <small>In case you forget something</small><br/>
                        <sf:errors path="email" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <sf:checkbox path="updateByEmail"/>
                        <sf:label path="updateByEmail">Send me email update!</sf:label>
                    </td>
                </tr>
                <tr>
                    <th><label for="image">Profile image:</label> </th>
                    <td><input name="image" type="file" id="image"/></td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input name="commit" type="submit" value="I accept"/>
                    </td>
                </tr>
            </table>
        </fieleset>
    </sf:form>
</di>