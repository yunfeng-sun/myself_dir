<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/template/jsp/taglibs.jspf"%>
<head>

    <%--<link href="${skinUrl}${themePath}.css?ver=${v}" rel="stylesheet" type="text/css" />--%>
    <%--<!-- Le styles -->--%>
    <%--<link href="${skinUrl}/portal/portal.css?ver=${v}" rel="stylesheet">--%>




    <sys:i18n-include lang="zh_cn" />

    <%--<script src="${base}/html/js/nav/spliter.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/js/portal/portal.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/js/portal/portal_object.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/js/portal/tabs_object.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/js/portal/jquery-ui.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/js/portal/scripts.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/thirdparty/jquery.easing/jquery.easing.1.3.js?ver=${v}" type="text/javascript"></script>--%>
    <%--<script src="${base}/html/js/nav/dynamicTab.js?ver=${v}" type="text/javascript"></script>--%>
    <style>
        .portal .box2 {
            padding-top: 5px;
        }
    </style>
    <script type="text/javascript">
        top.pptHtmlDom = '';//父页面向子页面传参(子页面获取方式为top.htmlDom)

        var resourceId = "${currentResourceId}";

        function initComplete() {
            loadCommonWidget();
            loadBusinessWidget();
            changeStatus_View();
        }

        function changeStatus_View() {
            $("body").removeClass("edit");
            $("body").addClass("run");
            <sys:authorize access="_PortalSetting">
            $("#spliter").spliterClose();
            $("#spliter").hide();
            $(".showHide").hide();
            </sys:authorize>
        }
        /*
         *通用组件
         */
        function loadCommonWidget() {
            var ctree = '<li class="dropdown">';
            ctree += picWidget();
            ctree += slidePicWidget();
            ctree += textWidget();
            ctree += tabsWidget();
            ctree += '</li>';
            $('#commonWidget').append(ctree);
        }
        /*
         *图片
         */
        function picWidget() {
            var wd = '<ul><li onClick="change_view(\'common_widget_pic\',this)" style="cursor:pointer;"><i class="img-minus"></i><span>'+ FOTON_GLOBAL.i18n.translate('图片') + '</span></li></ul>';
            wd += '<ul id="common_widget_pic">';
            wd += picWidget_pic1();
            wd += '</ul>';
            return wd;
        }

        function picWidget_pic1() {
            var pwc = '';
            pwc += '<li>';
            pwc += '<div class="box box-element ui-draggable">';
            pwc += '<span class="portlet-title">'+ FOTON_GLOBAL.i18n.translate('图片') + '</span>';
            pwc += '<a href="#close" class="edit-single-img label"><i class="img-edit"></i></a>';
            pwc += '<a href="#close" class="remove label"><i class="img-remove"></i></a>';
            pwc += '<span class="drag label"><i class="img-move"></i></span>';
            pwc += '<div class="portal_panel box2" panelWidth="100%" panelTitle="图片">';
            pwc += '<div class="view" style="overflow: hidden;">';
            pwc += '<img class="common_widget" src=""/>';
            pwc += '</div>';
            pwc += '</div>';
            pwc += '</div>';
            pwc += '</li>';
            return pwc;
        }

        /*
         *轮播图片
         */
        function slidePicWidget() {
            var wd = '<ul><li onClick="change_view(\'common_widget_slide\',this)" style="cursor:pointer;"><i class="img-plus"></i><span>'+ FOTON_GLOBAL.i18n.translate('轮询图片') + '</span></li></ul>';
            wd += '<ul id="common_widget_slide" style="display:none;" >';
            wd += slideWidget_1();
            wd += '</ul>';
            return wd;
        }

        function slideWidget_1() {
            var html = "";
            html += '<div class="carousel slide" id="myCarousel"><ol class="carousel-indicators">';
            html += '</ol><div class="carousel-inner">';
            html += '<div class="item active"><img alt="" src=""><div class="carousel-caption" contenteditable="true"><p></p></div></div>';
            html += '<div class="item"><img alt="" src=""><div class="carousel-caption" contenteditable="true"><p></p></div></div>';
            html += '</div><a data-slide="prev" href="#myCarousel" class="left carousel-control">‹</a> <a data-slide="next" href="#myCarousel" class="right carousel-control">›</a></div>';
            var pwc = '';
            pwc += '<li>';
            pwc += '<div class="box box-element ui-draggable">';
            pwc += '<span class="portlet-title">'+ FOTON_GLOBAL.i18n.translate('幻灯片') + '</span>';

            pwc += '<a href="#close" class="edit-ppt label"><i class="img-edit"></i></a>';

            pwc += '<a href="#close" class="remove label"><i class="img-remove"></i></a>';
            pwc += '<span class="drag label"><i class="img-move"></i></span>';
            pwc += '<div class="view">';
            pwc += '<div id="play"> ';
            pwc += '<span>' + html + '</span>';
            pwc += '</div>';
            pwc += '</div>';
            pwc += '</div>';
            pwc += '</li>';
            return pwc;
        }

        /*
         *文字页面
         */
        function textWidget() {
            var wd = '<ul><li onClick="change_view(\'common_widget_text\',this)" style="cursor:pointer;"><i class="img-plus"></i><span>'+ FOTON_GLOBAL.i18n.translate('文本') + '</span></li></ul>';
            wd += '<ul id="common_widget_text" style="display:none;">';
            wd += textWidget_txt1();
            wd += '</ul>';
            return wd;
        }

        function textWidget_txt1() {
            var pwc = '';
            pwc += '<li>';
            pwc += '<div class="box box-element ui-draggable">';
            pwc += '<span class="portlet-title">'+ FOTON_GLOBAL.i18n.translate('文本公告') + '</span>';
            pwc += '<a href="#close" class="edit-text label"><i class="img-edit"></i></a>';
            pwc += '<a href="#close" class="remove label"><i class="img-remove"></i></a>';
            pwc += '<span class="drag label"><i class="img-move"></i></span>';
            pwc += '<div class="portal_panel box2" panelWidth="100%" panelTitle="文本公告">';
            pwc += '<div class="view" style="overflow: hidden;">';
            //  		pwc += '<img CLASS="common_widget" src=""/>';
            pwc += '<span>'+ FOTON_GLOBAL.i18n.translate('请输入文本') + '</span>';
            pwc += '</div>';
            pwc += '</div>';
            pwc += '</div>';
            pwc += '</li>';
            return pwc;
        }

        //选项卡组件
        function tabsWidget() {
            var tab = '<ul><li onClick="change_view(\'common_widget_tabs\',this)" style="cursor:pointer;"><i class="img-plus"></i><span>'+ FOTON_GLOBAL.i18n.translate('选项卡') + '</span></li></ul>';
            tab += '<ul id="common_widget_tabs" style="display:none;">';
            tab += tabsWidget_context();
            tab += '</ul>';
            return tab;
        }

        function tabsWidget_context() {
            var tab = '<li>';
            tab += '<div class="box box-element ui-draggable">';
            tab += '<span class="portlet-title">'+ FOTON_GLOBAL.i18n.translate('组件选项卡') + '</span>';
            tab += '<a href="#close" class="tabs_config label"><i class="img-config"></i></a> <a href="#close" class="remove label"><i class="img-remove"></i></a> <span class="drag label"><i class="img-move"></i></span>';
            tab += '<input class="tab_urls" type="hidden" value="">';
            tab += '<input class="tab_style" type="hidden" value="default">';
            tab += '<input class="ids" id="ids" type="hidden" value="">';
            tab += '<input class="tab_params" type="hidden" value="">';
            tab += '<div class="portal_tabs box2" panelWidth="100%" panelTitle="' + FOTON_GLOBAL.i18n.translate('请填写标题') + '">';
            tab += '<div class="view">';
            tab += '<div id="tab_menu" class="tab_droppable"></div>';
            tab += '<div id="tab_page" style="width:100%;height:100%;border:solid 1px #cccccc;"></div>';
            tab += '</div>';
            tab += '</div>';
            tab += '</div>';
            tab += '</li>';
            return tab;
        }

        function loadBusinessWidget() {
            $.post("${base}/manage/resource!listUserWidget.do", {}, function(result) {
                if (result.list.length > 0) {
                    var dtree = '<li class="dropdown">';

                    for (var i = 0; i < result.list.length; i++) {
                        var widgets = result.list[i].children;
                        dtree += htmlWidgets(widgets);
                    }
                    dtree += '</li>';
                    $('#groupWidget').append(dtree);
                }
            }, "json");
        }

        function htmlWidgets(widgets) {
            var divTree = ''
            for (var i = 0; i < widgets.length; i++) {
                if (widgets[i].isParent || widgets[i].url == "") {
                    divTree += '<ul>';
                    if (i == 0) {
                        divTree += '<li onClick="change_view(\'widget' + i + '\',this)" style="cursor:pointer;"><i class="img-minus"></i><span>' + widgets[i].name + '</span></li>';
                        divTree += '</ul>';
                        divTree += '<ul id="widget'+i+'">';
                    } else {
                        divTree += '<li onClick="change_view(\'widget' + i + '\',this)" style="cursor:pointer;"><i class="img-plus"></i><span>' + widgets[i].name + '</span></li>';
                        divTree += '</ul>';
                        divTree += '<ul id="widget'+i+'" style="display:none;">';
                    }

                    if (widgets[i].children) {
                        for (var j = 0; j < widgets[i].children.length; j++) {
                            divTree += '<li>';
                            divTree += '<div class="box box-element ui-draggable">';
                            divTree += '<span class="portlet-title">' + widgets[i].children[j].name + '</span>';
                            divTree += '<a href="#close" class="config label"><i class="img-config"></i></a> <a href="#close" class="remove label"><i class="img-remove"></i></a> <span class="drag label"><i class="img-move"></i></span>';
                            divTree += '<input class="src" type="hidden" value="'+widgets[i].children[j].url+'">';
                            divTree += '<input class="portalType" type="hidden" value="iframe,1">';
                            if (widgets[i].children[j].componentType == 1) {
                                divTree += '<div class="portal_panel chart_panel box2" panelWidth="100%" panelTitle="' + widgets[i].children[j].name + '">';
                            } else if (widgets[i].children[j].componentType == 2) {
                                divTree += '<div class="portal_panel map_panel box2" panelWidth="100%" panelTitle="' + widgets[i].children[j].name + '">';
                            }else if (widgets[i].children[j].componentType == 3) {
                                divTree += '<div class="portal_panel real_panel box2" panelWidth="100%" panelTitle="' + widgets[i].children[j].name + '">';
                            }else {
                                divTree += '<div class="portal_panel module_panel box2" panelWidth="100%" panelTitle="' + widgets[i].children[j].name + '">';
                            }

                            divTree += '<div class="view">';
                            divTree += '<IFRAME scrolling="auto" height="100%" width="100%" frameBorder="0" id="myIframe" name="widgetFrame" allowTransparency="true"></IFRAME>';
                            divTree += '</div>';
                            divTree += '</div>';
                            divTree += '</div>';
                            divTree += '</li>';
                        }
                    }
                    divTree += '</ul>';
                } else {
                    divTree += '<li>';
                    divTree += '<div class="box box-element ui-draggable">';
                    divTree += '<span class="portlet-title">' + widgets[i].name + '</span>';
                    divTree += '<a href="#close" class="remove label"><i class="img-remove"></i></a> <span class="drag label"><i class="img-move"></i></span>';
                    divTree += '<input class="src" type="hidden" value="'+widgets[i].url+'">';
                    divTree += '<input class="portalType" type="hidden" value="iframe,1">';
                    if (widgets[i].componentType == 1) {
                        divTree += '<div class="portal_panel chart_panel box2" panelWidth="100%" panelTitle="' + widgets[i].name + '">';
                    } else if (widgets[i].componentType == 2) {
                        divTree += '<div class="portal_panel map_panel box2" panelWidth="100%" panelTitle="' + widgets[i].name + '">';
                    } else if (widgets[i].componentType == 3) {
                        divTree += '<div class="portal_panel real_panel box2" panelWidth="100%" panelTitle="' + widgets[i].name + '">';
                    } else {
                        divTree += '<div class="portal_panel module_panel box2" panelWidth="100%" panelTitle="' + widgets[i].name + '">';
                    }

                    divTree += '<div class="view">';
                    divTree += '<IFRAME scrolling="auto" height="100%" width="100%" frameBorder="0" id="myIframe" name="widgetFrame" allowTransparency="true"></IFRAME>';
                    divTree += '</div>';
                    divTree += '</div>';
                    divTree += '</div>';
                    divTree += '</li>';
                }
            }
            return divTree;
        }

        function   change_view(obj_id, ulObj) {
            var obj = document.getElementById(obj_id);

            if (obj.style.display == "") {
                obj.style.display = "none";
            } else {
                obj.style.display = "";
            }
            var oul = $(ulObj).find('i').attr("class");
            if (oul.indexOf("img-plus") != -1) {
                $(ulObj).find('i').attr("class", "img-minus");
            } else {
                $(ulObj).find('i').attr("class", "img-plus");
            }
        }
    </script>
</head>
<body class="edit">
<div id="mainFrame">
    <table width="100%" height="100%" cellpadding="0" cellspacing="0" class="table_border0">
        <tr>
            <sys:authorize access="_PortalSetting">
                <td id="hideCon" style="display:none;" class="ver01 ali01">
                    <div id="lbox">
                        <div id="lbox_topcenter">
                            <div id="lbox_topleft">
                                <div id="lbox_topright"></div>
                            </div>
                        </div>
                        <div id="lbox_middlecenter">
                            <div id="lbox_middleleft">
                                <div id="lbox_middleright">
                                    <div id="bs_left">
                                        <jsp:include page="./portal_tree.jsp"></jsp:include>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="lbox_bottomcenter">
                            <div id="lbox_bottomleft">
                                <div id="lbox_bottomright">
                                    <div class="lbox_foot"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <td id="spliter" style="display:none;" class="spliter main_shutiao" targetid="hideCon" beforeclicktip="收缩面板" afterclicktip="展开面板" beforeclickclass="bs_leftArr"
                    afterclickclass="bs_rightArr" init="show"></td>
            </sys:authorize>
            <td class="ali01 ver01" width="100%" style="background-color: #ffffff;">
                <div id="rbox" style="background-color: #ffffff;">
                    <div id="rbox_topcenter">
                        <div id="rbox_topleft">
                            <div id="rbox_topright"></div>
                        </div>
                    </div>
                    <div id="rbox_middlecenter">
                        <div id="rbox_middleleft">
                            <div id="rbox_middleright">
                                <sys:authorize access="_PortalSetting">
                                    <div class="box_tool_min">
                                        <jsp:include page="./portal_content.jsp"></jsp:include>
                                    </div>
                                </sys:authorize>
                                <div class="portal ui-sortable" style="min-height: 304px;"></div>
                            </div>
                        </div>
                    </div>
                    <div id="rbox_bottomcenter">
                        <div id="rbox_bottomleft">
                            <div id="rbox_bottomright"></div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </table>
</div>
<div>
    <input id="userId" type="hidden" value="${currentUserId}">
    <input id="companyId" type="hidden" value="${currentCompanyId}">
    <input id="productId" type="hidden" value="${currentCompany.product.id}">
    <input id="resourceId" type="hidden" value="${currentResourceId}">
    <input id="id" type="hidden">
    <input id="portalType" type="hidden" value="">
</div>
</body>
