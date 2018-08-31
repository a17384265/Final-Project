<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {

        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                $("#dd").dialog("open");
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-help',
            handler: function () {
                /*
                 * 删除数据
                 *
                 * */
                var rows = $("#dg").datagrid("getSelections")
                var id = rows[0].id
                $.ajax({
                    url: '${pageContext.request.contextPath}/Banner/delete.do',
                    data: "id=" + id,
                    success: function (data) {
                    }
                })
                $("#dg").edatagrid("destroyRow")
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-help',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#dg").datagrid("getSelected");
                if (row != null) {

                    var index = $("#dg").datagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow")
                var rows = $("#dg").datagrid("getSelections")
                var id = rows[0].id
                var title = rows[0].title
                var description = rows[0].description
                var status = rows[0].status
                $.ajax({
                    url: "${pageContext.request.contextPath}/Banner/updateBanner.do",
                    data: {"id": id, "title": title, "description": description, "status": status},
                    type: "post",
                })
            }
        }]
        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/Banner/showAllBanners.do',
            method: "get",
            updateUrl: "${pageContext.request.contextPath}/cmfz/banner/add",
            columns: [[

                {field: 'id', title: '编号', width: 100},
                {
                    field: 'title', title: '名称', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {
                    field: 'description', title: '描述', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'createDate', title: '时间', width: 100}

            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    })
    function submit() {
        $("#ff").form("submit", {
            url: "${pageContext.request.contextPath}/Banner/addBanners"
        })
    }
</script>

<table id="dg"></table>
<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#dd').dialog('close');
                      $('#dg').edatagrid('reload')
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#dd').dialog('close');
				}
			}]">
    <form id="ff" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>

                    <label for="title">title:</label>
                </td>
                <td>
                    <input class="easyui-validatebox" id="title" type="text" name="title" data-options="required:true"
                           style="width: 150px"/>

                </td>
            </tr>
            <tr>
                <td>

                    <label for="description">description:</label>
                </td>
                <td>
                    <input class="easyui-textbox" type="text" id="description" name="description" data-options=""
                           style="width: 150px"/>

                </td>
            </tr>
            <tr>
                <td>
                    <label for="status">status:</label>
                </td>
                <td>
                    <select id="cc" class="easyui-combobox" id="status" name="status" style="width: 150px">
                        <option value="Y">展示</option>
                        <option value="N">不展示</option>
                    </select>

                </td>
            </tr>
            <tr>
                <td>
                    <label for="img">img:</label>
                </td>
                <td>
                    <input class="easyui-filebox" id="img" name="img" style="width: 150px">
                </td>
            </tr>
        </table>
    </form>


</div>


