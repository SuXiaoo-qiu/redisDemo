(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-a1c87862"],{"0c7e":function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"picture",staticStyle:{"line-height":"25px"}},[a("el-row",[a("el-col",{attrs:{span:21}},[a("div",{staticClass:"grid-content bg-purple"},[a("el-form",{staticClass:"demo-form-inline",attrs:{inline:!0,model:t.pictureFormLike}},[a("el-form-item",{attrs:{label:"图片名称"}},[a("el-input",{attrs:{placeholder:"请输入图片名称",clearable:""},model:{value:t.pictureFormLike.pictureName,callback:function(e){t.$set(t.pictureFormLike,"pictureName",e)},expression:"pictureFormLike.pictureName"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:t.search}},[t._v("查询")])],1)],1)],1)]),a("el-col",{attrs:{span:3}},[a("div",{staticClass:"grid-content bg-purple-light"},[a("el-button",{attrs:{type:"primary"},on:{click:t.insert}},[t._v("新增")])],1)])],1),a("el-row",[a("el-table",{staticClass:"tableBox",staticStyle:{width:"100%"},attrs:{data:t.tableData}},[a("el-table-column",{attrs:{prop:"pictureName",label:"图片名称"}}),a("el-table-column",{attrs:{prop:"pictureUrl",label:"图片地址","show-overflow-tooltip":!0},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-link",{attrs:{type:"primary",underline:!1},on:{click:function(a){return t.clickPictureUrl(e.row)}}},[t._v(t._s(e.row.pictureUrl))])]}}])}),a("el-table-column",{attrs:{prop:"createPeople",label:"创建人"}}),a("el-table-column",{attrs:{prop:"createTime",label:"创建时间"}}),a("el-table-column",{attrs:{prop:"uodatePeople",label:"修改人"}}),a("el-table-column",{attrs:{prop:"uodateTime",label:"修改时间"}}),a("el-table-column",{attrs:{width:"300",label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){return t.toEditPro(e.row)}}},[t._v("编辑")]),a("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(a){return t.toDelPicture(e.row)}}},[t._v("删除")])]}}])})],1)],1),a("el-row",[a("el-pagination",{attrs:{"current-page":t.currentPage,"page-sizes":[5,10,20,100,200,300,400],"page-size":t.pageSize,layout:"total, sizes, prev, pager, next, jumper",total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),a("el-row",[a("el-dialog",{attrs:{title:"图片管理",visible:t.editProState},on:{"update:visible":function(e){t.editProState=e}}},[a("el-form",{attrs:{model:t.pictureForm}},[a("el-upload",{ref:"upload",attrs:{action:"","on-change":t.getFile,limit:1,"list-type":"picture","auto-upload":!1}},[a("el-button",{attrs:{size:"small",type:"primary"}},[t._v("选择图片上传,最多上传一张图片")])],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.editProState=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.saveInfo}},[t._v("确 定")])],1)],1)],1)],1)},i=[],o=(a("b0c0"),a("d3b7"),{data:function(){return{pictureFormLike:{pictureName:""},tableData:[],currentPage:1,pageSize:5,total:100,pictureForm:{pictureName:"",pictureUrl:""},editProState:!1}},created:function(){this.load()},methods:{load:function(){var t=this;this.$http({method:"post",url:"/Picture/getPage",data:{pageCode:this.currentPage,pageSize:this.pageSize,pictureName:this.pictureFormLike.pictureName}}).then((function(e){200==e.status&&(t.tableData=e.data.list,t.total=e.data.total)}))},search:function(){this.load()},handleSizeChange:function(t){this.pageSize=t,this.load()},handleCurrentChange:function(t){this.currentPage=t,this.load()},insert:function(){this.pictureForm={},this.editProState=!0,this.$refs.upload.clearFiles()},toEditPro:function(t){var e=this;this.pictureForm={};var a=t.id;this.$http({method:"get",url:"/Picture/getById",params:{id:a}}).then((function(t){200==t.data.code&&(e.pictureForm=t.data.data,e.editProState=!0,e.$refs.upload.clearFiles())}))},saveInfo:function(){var t=this;console.log("保存的数据为：",this.pictureForm),null!=this.pictureForm.id?(this.pictureForm.uodatePeople=sessionStorage.getItem("name"),this.$http({method:"post",url:"/Picture/updateById",data:this.pictureForm}).then((function(e){var a=e.data.code;200==a?(t.editProState=!1,t.load(),t.$message.success({message:e.data.msg})):t.$message.error({message:e.data.msg})}))):(this.pictureForm.createPeople=sessionStorage.getItem("name"),this.$http({method:"post",url:"/Picture/add",data:this.pictureForm}).then((function(e){var a=e.data.code;200==a?(t.editProState=!1,t.load(),t.$message.success({message:e.data.msg})):t.$message.error({message:e.data.msg})})))},toDelPicture:function(t){var e=this;this.$confirm("此操作将永久删除该文件, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var a=t.id;e.$http({method:"get",url:"/Picture/delete",params:{id:a}}).then((function(t){200==t.data.code?(e.load(),e.$message.success({message:t.data.msg})):e.$message.error({message:t.data.msg})}))}))},getFile:function(t,e){var a=this,r={pictureName:t.name,pictureUrl:""};this.getBase64(t.raw).then((function(t){r.pictureUrl=t,a.$nextTick((function(){a.pictureForm=Object.assign(a.pictureForm,r),console.log("表单数据为：",a.pictureForm)}))}))},getBase64:function(t){return new Promise((function(e,a){var r=new FileReader,i="";r.readAsDataURL(t),r.onload=function(){i=r.result},r.onerror=function(t){a(t)},r.onloadend=function(){e(i)}}))},clickPictureUrl:function(t){var e=new window.Image;e.src=t.pictureUrl;var a=window.open("");a.document.body.style.background="#000",a.document.body.style.textAlign="center",a.document.body.appendChild(e),a.document.title="图片预览",a.document.close()}}}),n=o,l=(a("a3a2"),a("2877")),c=Object(l["a"])(n,r,i,!1,null,null,null);e["default"]=c.exports},a3a2:function(t,e,a){"use strict";a("a722")},a722:function(t,e,a){},b0c0:function(t,e,a){var r=a("83ab"),i=a("9bf2").f,o=Function.prototype,n=o.toString,l=/^\s*function ([^ (]*)/,c="name";r&&!(c in o)&&i(o,c,{configurable:!0,get:function(){try{return n.call(this).match(l)[1]}catch(t){return""}}})}}]);
//# sourceMappingURL=chunk-a1c87862.f33757af.js.map