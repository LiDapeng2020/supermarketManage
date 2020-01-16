'use strict'
$(function () {
    $(".easyui-tree").tree({
        onClick:function (node) {
            if (node.attributes == null || node.attributes.url == null){
                return;
            }
            let has = $("#tabs1").tabs("exists", node.text);
            if (has){
                $("#tabs1").tabs("select", node.text);
                /*//刷新
                let tab = $('#tabs1').tabs('getSelected');
                tab.panel('refresh', node.attributes.url);*/
            }else {
                $("#tabs1").tabs("add", {
                    "title": node.text,
                    "closable": true,
                    "selected": true,
                    "iconCls": node.attributes.icon,
                    "content": "<iframe src='" + node.attributes.url + "' style='width:100%;height:98%' frameborder='0'></iframe>"
                });
            }
            // console.info(node);
        }
    })
})