<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "专辑详情",
            handler: function () {
                var row = $("#ttt").treegrid("getSelected");
                if (row != null) {
                    if (row.author != null) {
                        $("#album_dd").dialog("open");
                        $('#album_zj').form('load', row);
                        $('#img').prop('src', "${pageContext.request.contextPath}/upload/" + row.corverImg);
                    } else {
                        alert("请选中专辑");
                    }
                } else {
                    alert("请选择要查询的专辑");
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-help',
            handler: function () {
                $("#album_ee").dialog("open");
            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-help',
            handler: function () {
                $("#album_zjj").dialog("open");
            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-help',

        }]
        $('#ttt').treegrid({
            url: '${pageContext.request.contextPath}/Album/showAllAlbum.do',
            method: "get",
            idField: 'id',
            treeField: 'title',
            toolbar: toolbar,
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'size', title: '大小', width: 60},
                {field: 'audioPath', title: '路径', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns: true
        });
    })
    function submit() {
        $("#album_tj").form("submit", {
            url: "${pageContext.request.contextPath}/Album/addAlbums.do",
        })
    }
    function submit() {
        $("#album_tjzj").form("submit", {
            url: "${pageContext.request.contextPath}/Album/addAlbums.do",
        })
    }
</script>
<table id="ttt"></table>
<div id="album_dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="album_zj" method="post">
        <table>
            <tr>
                <td><label for="title">标题:</label></td>
                <td><input class="easyui-validatebox" type="text" id="title" name="title" data-options="" readonly/>
                </td>
            </tr>
            <tr>
                <td><label for="count">集数:</label></td>
                <td><input class="easyui-validatebox" type="text" id="count" name="count" data-options="" readonly/>
                </td>
            </tr>
            <tr>
                <td><label for="score">评分:</label></td>
                <td><input class="easyui-validatebox" id="score" type="text" name="score" data-options="required:true"
                           style="width: 150px" readonly/></td>
            </tr>
            <tr>
                <td><label for="author">作者:</label></td>
                <td><input class="easyui-validatebox" id="author" type="text" name="author" data-options="required:true"
                           style="width: 150px" readonly/></td>
            </tr>
            <tr>
                <td><label for="broadCast">播音:</label></td>
                <td><input class="easyui-validatebox" id="broadCast" type="text" name="broadCast"
                           data-options="required:true" style="width: 150px" readonly/></td>
            </tr>
            <tr>
                <td><label for="publiceDate">发布日期:</label></td>
                <td><input class="easyui-validatebox" id="publiceDate" type="text" name="publicDate"
                           data-options="required:true" style="width: 150px" readonly/></td>
            </tr>
            <tr>
                <td><label for="acreateDate">创建日期:</label></td>
                <td><input class="easyui-validatebox" id="acreateDate" type="text" name="createDate"
                           data-options="required:true" style="width: 150px" readonly/></td>
            </tr>
            <tr>
                <td><label for="brife">内容简介:</label></td>
                <td><input class="easyui-validatebox" type="text" id="brife" name="brife" data-options="" readonly/>
                </td>
            </tr>
        </table>
        <div>
            <img src="" id="img" alt="" width="192" height="108">
        </div>
    </form>
</div>
<div id="album_ee" class="easyui-dialog" title="My Dialog" style="width:500px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#album_ee').dialog('close');
                      $('#ttt').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#album_ee').dialog('close');
				}
			}]">
    <form id="album_tj" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td><label for="atitle">专辑名称:</label></td>
                <td><input class="easyui-validatebox" id="atitle" type="text" name="title" data-options="required:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="acount">集数:</label></td>
                <td><input class="easyui-validatebox" id="acount" type="text" name="count" data-options="required:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="acorverImg">专辑封面:</label></td>
                <td><input class="easyui-filebox" id="acorverImg" name="corverImg" style="width: 150px"></td>
            </tr>
            <tr>
                <td><label for="ascore">评分:</label></td>
                <td><input class="easyui-validatebox" id="ascore" type="text" name="score" data-options="required:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="aauthor">作者:</label></td>
                <td><input class="easyui-validatebox" id="aauthor" type="text" name="author"
                           data-options="required:true" style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="abroadCast">播音:</label></td>
                <td><input class="easyui-validatebox" id="abroadCast" type="text" name="broadCast"
                           data-options="required:true" style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="brife">内容简介:</label></td>
                <td><input class="easyui-validatebox" id="abrife" type="text" name="brife" data-options="required:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="publicDate">公开日期:</label></td>
                <td><input class="easyui-validatebox" id="publicDate" type="date" name="publicDate"
                           data-options="required:true" style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="createDate">公开日期:</label></td>
                <td><input class="easyui-validatebox" id="createDate" type="date" name="createDate"
                           data-options="required:true" style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="status">状态:</label></td>
                <td><select id="cc" class="easyui-combobox" id="status" name="status" style="width: 150px">
                    <option value="Y">展示</option>
                    <option value="N">不展示</option>
                </select></td>
            </tr>
        </table>
    </form>
</div>
<div id="album_zjj" class="easyui-dialog" title="My Dialog" style="width:500px;height:400px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#album_zjj').dialog('close');
                      $('#ttt').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#album_zjj').dialog('close');
				}
			}]">
    <form id="album_tjzj" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td><label for="ctitle">章节名称:</label></td>
                <td><input class="easyui-validatebox" id="ctitle" type="text" name="title" data-options="required:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="duration">音频时长:</label></td>
                <td><input class="easyui-validatebox" id="duration" type="text" name="duration"
                           data-options="required:true" style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="size">音频大小:</label></td>
                <td><input class="easyui-validatebox" id="size" type="text" name="size" data-options="required:true"
                           style="width: 150px"/></td>
            </tr>
            <tr>
                <td><label for="audioPath">音频:</label></td>
                <td><input class="easyui-filebox" id="audioPath" name="audioPath" style="width: 150px"></td>
            </tr>
            <tr>
                <td><label for="album_id">所属专辑:</label></td>
                <td><input class="easyui-validatebox" id="album_id" type="text" name="album_id"
                           data-options="required:true" style="width: 150px"/></td>
            </tr>
        </table>
    </form>
</div>


