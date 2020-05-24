var win_width = $(window).width();
var win_height = $(window).height();
var menu_w = 200;   //Ĭ��menu�˵��Ŀ��

$(document).ready(function(){


    $(".main").width(win_width + "px").height(win_height - 70 - 50 - 15 + "px");

    $(".menu").height(win_height - 50 + "px");

    $(".main_body").width(win_width - menu_w + "px").height(win_height - 50 + "px");

    $(".main_body_con").height(win_height - 50 - 49 - 51 + "px");

    $(window).resize(function(){
        win_width = $(window).width();
        win_height = $(window).height();

        if(win_width <= 1200 ){
            win_width = 1200;
        }
	    $(".main").width(win_width + "px").height(win_height - 70 - 50 - 15 + "px");
	
	    $(".menu").height(win_height - 50 + "px");
	
	    $(".main_body").width(win_width - menu_w + "px").height(win_height - 50 + "px");
	
	    $(".main_body_con").height(win_height - 50 - 49 - 51 + "px");
    });

    //menu�˵�����¼�
    $(".menua1").click(function(){

        var num = $(this).parent().index();
        var nums = $(this).parent().parent().find(".menuli1").length;
		
        if($(this).parent().find(".menu2").length === 0){
            //console.log("����");
            for(var r = 0; r < nums; r++){
                var menuli2_nums = $(this).parent().parent().children().eq(r).find(".menu2").find(".menuli2").length;
                //alert(menuli2_nums)
                for(var j = 0; j < menuli2_nums; j++){
                    $(this).parent().parent().children().eq(r).find(".menu2").children().eq(j).find(".menua2").attr("class","menua2");
                }
            }
        }else{
        	//��ǰ�����˵����չ���Ļ�����ر�
	        if($(this).parent().find(".menu2").css("display") == "block"){
	        	$(this).parent().find(".menu2").hide();
	        	$(this).find(".right").attr("class","iconfont icon-jiantou_zuo right");
	        	return;
	        }
            for(var i = 0; i < nums; i++){
                if(num == i){
                    $(".menuList .menu1").children().eq(num).find(".menu2").show();
                    $(".menuList .menu1").children().eq(num).find(".menua1").find(".right").attr("class","iconfont icon-jiantou_down right");
                }else{
                    $(".menuList .menu1").children().eq(i).find(".menu2").hide();
                    $(".menuList .menu1").children().eq(i).find(".menua1").find(".right").attr("class","iconfont icon-jiantou_zuo right");
                }
            }
        }
        $(".menua2").click(function(){
            for(var r = 0; r < nums; r++){
                var menuli2_nums = $(this).parent().parent().parent().parent().children().eq(r).find(".menu2").find(".menuli2").length;
                //alert(menuli2_nums)
                for(var j = 0; j < menuli2_nums; j++){
                    $(this).parent().parent().parent().parent().children().eq(r).find(".menu2").children().eq(j).find(".menua2").attr("class","menua2");
                }
            }
            $(this).attr("class","menua2 active");
        });

    });

    //top�Ҳ��ݲ˵�
    $(".top span").mouseenter(function(){
        $(this).find("ul").show();
    });
    $(".top span").mouseleave(function(){
        $(this).find("ul").hide();
    });


});

//��תҳ��ķ���
function menu_ajax(urlStr, current_location){
    //�����ַ����������
    //<a>�ͻ�����</a><a>&gt;</a><a>�ͻ���Ƭ</a>
    var list = current_location.split(",");
    var nums = list.length;
    //console.log(nums);
    var result = "";
    for (var i = 0; i < nums; i++){
        if(i != nums-1){
            result += "<a>"+ list[i] +"</a>" + "<a>&gt;</a>";
        }else{
            result += "<a>"+ list[i] +"</a>";
        }
    }
    $(".main_body .main_body_title font").html(result);

	//����frameMain url��ַ
	$("#mainIframe").attr("src",urlStr);
}

//����������js - ��ʼ
function open_tc(tc_class, tag){
    //console.log(tc_class+"-"+tag);
    if(tc_class == "add_department" && tag == 1){
        //console.log(tc_class+"-"+tag);
        $(".add_control_but .del").css("display","inline-block");
    }else{
        $(".add_control_but .del").hide();
    }
    $("." + tc_class).show();
}
function close_tc(tc_class){
    $("." + tc_class).hide();
}
//����������js - ����

