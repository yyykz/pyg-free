//自定义公共功能控制器
app.controller('baseController',function ($scope) {

    //分页控件配置
    //currentPage : 当前页
    //totalItems : 总条数
    //itemsPerPage : 每页显示的条数
    //perPageOptions :  每页显示条数的选项
    //onChange : 改变事件
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30, 40, 50, 70],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };
    //重新加载函数
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        // $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
    //点击复选框checkbox
    //保存点击多个复选框id的数组
    $scope.selectIds=[];
    $scope.updateSelected=function ($event,id) {
        if($event.target.checked){
            //选中状态
            //将选中的id放入数组中
            $scope.selectIds.push(id);
            console.log($scope.selectIds);
        }else {
            //取消状态
            //移除数组中的id
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }

    };
})