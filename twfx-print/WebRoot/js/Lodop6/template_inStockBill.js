/**
 * LODOP API说明
 * ADD_PRINT_TEXT(Top,Left,Width,Height,strContent) 
 * ADD_PRINT_LINE(Top1,Left1, Top2, Left2,intLineStyle, intLineWidth)
 * @param obj
 * @param LODOP
 */

// 入库单打印模板
function printInStockBill(obj, LODOP){
	var high = 16;
	LODOP.PRINT_INIT("InStockBillTemplate");
	LODOP.SET_PRINT_STYLE("FontSize",9);
	LODOP.ADD_PRINT_TEXT(8,350,258,21, "采购入库单");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	// 第一行
	
	LODOP.ADD_PRINT_TEXT(35,37,260,high,"入库单号："+obj.id);
	LODOP.ADD_PRINT_TEXT(35,297,260,high,"入库日期："+obj.inStockDate);
	LODOP.ADD_PRINT_TEXT(35,557,260,high,"仓    库："+obj.wareHouse);
	// 第二行
	LODOP.ADD_PRINT_TEXT(55,37,260,high,"供货单位："+obj.supplyCompany);
	LODOP.ADD_PRINT_TEXT(55,297, 260,high,"备    注："+obj.remark);
	
	
	// 入库单明细
	var vsline = 75; // 垂直线开始位置
	LODOP.ADD_PRINT_LINE(75,34,75,725,0,1);
	LODOP.ADD_PRINT_TEXT(78,37,80,high,"存货编号");
	LODOP.ADD_PRINT_TEXT(78,119,200,high,"存货名称");
	LODOP.ADD_PRINT_TEXT(78,321,100,high,"规格型号");
	LODOP.ADD_PRINT_TEXT(78,423,100,high,"数量");
	LODOP.ADD_PRINT_TEXT(78,525,100,high,"单价");
	LODOP.ADD_PRINT_TEXT(78,627,100,high,"金额");
	LODOP.ADD_PRINT_LINE(95,34,95,725,0,1);
	
	var iCurLine=95;
	var items = obj.details;
	if(items.length>0){
		var sumNum = 0.0;
		var sumMoney = 0.00;
		for (var i = 0; i < items.length; i++) {
			sumNum += items[i].num;
			sumMoney += items[i].money;
			iCurLine = iCurLine + 2;
			LODOP.ADD_PRINT_TEXT(iCurLine,37,100,high,items[i].goodsId);
			LODOP.ADD_PRINT_TEXT(iCurLine,119,200,high,items[i].goodsName);
			LODOP.ADD_PRINT_TEXT(iCurLine,321,100,high,items[i].model);
			LODOP.ADD_PRINT_TEXT(iCurLine,423,100,high,items[i].num);
			LODOP.ADD_PRINT_TEXT(iCurLine,525,100,high,items[i].unitPrice);
			LODOP.ADD_PRINT_TEXT(iCurLine,627,100,high,items[i].money);
			iCurLine=iCurLine+high;//每行占16px
			LODOP.ADD_PRINT_LINE(iCurLine,34,iCurLine,725,0,1);
		}
		
		// 合计
		iCurLine = iCurLine + 2;
		LODOP.ADD_PRINT_TEXT(iCurLine,37,100,high,"合计：");
		LODOP.ADD_PRINT_TEXT(iCurLine,119,200,high,"");
		LODOP.ADD_PRINT_TEXT(iCurLine,321,100,high,"");
		LODOP.ADD_PRINT_TEXT(iCurLine,423,100,high,sumNum);
		LODOP.ADD_PRINT_TEXT(iCurLine,525,100,high,"");
		LODOP.ADD_PRINT_TEXT(iCurLine,627,100,high,sumMoney);
		iCurLine=iCurLine+high;//每行占16px
		LODOP.ADD_PRINT_LINE(iCurLine,34,iCurLine,725,0,1);
		
		var veline = iCurLine; // 垂直线结束位置
		// 绘制表格竖线
		LODOP.ADD_PRINT_LINE(vsline,34,veline,34,0,1);
		LODOP.ADD_PRINT_LINE(vsline,116,veline,117,0,1);
		LODOP.ADD_PRINT_LINE(vsline,318,veline,319,0,1);
		LODOP.ADD_PRINT_LINE(vsline,420,veline,421,0,1);
		LODOP.ADD_PRINT_LINE(vsline,522,veline,523,0,1);
		LODOP.ADD_PRINT_LINE(vsline,624,veline,625,0,1);
		LODOP.ADD_PRINT_LINE(vsline,724,veline,724,0,1);
	
	}	
	LODOP.ADD_PRINT_TEXT(iCurLine+5,37,170,high,"业务员:");
	LODOP.ADD_PRINT_TEXT(iCurLine+5,207,170,high,"制单人:");
	LODOP.ADD_PRINT_TEXT(iCurLine+5,377,170,high,"审核人:");
	LODOP.ADD_PRINT_TEXT(iCurLine+5,547,170,high,"记账人:");
}


