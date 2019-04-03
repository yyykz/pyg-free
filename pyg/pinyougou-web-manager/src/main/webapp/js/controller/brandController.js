
//自定义控制器
app.controller('brandController', function ($scope,$controller,brandService) {
    //继承baseController
    $controller('baseController',{$scope:$scope});

    //查询所有品牌
    $scope.findAll = function () {
        brandService.findAll().success(function (response) {
            $scope.list = response;
        });
    };

    //条件查询
    //入参：当前页，每页数，条件对象
    $scope.searchEntity = {};
    $scope.search=function(currentPage, itemsPerPage){
        brandService.search(currentPage,itemsPerPage,$scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationConf.totalItems = response.total;
        })
    }
    //查询分页
    $scope.findPage = function (currentPage, itemsPerPage) {
        //请求   路径 /brand/findPage.do
        //入参://分页控件配置 当前页 每页数
        //响应  返回值:  分页对象 (结果集,总条数)
        brandService.findPage(currentPage,currentPage).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationConf.totalItems = response.total;
        });
    }
    //   添加/更改
    $scope.save = function () {
        /*生态框为公用模块，所以要判断当前使用的功能，
        点击新建按钮(添加功能)时会清空entity,所以以entity.id是否为null来判断使用的是添加还是更改*/
        var object = brandService.add( $scope.entity);
        if ($scope.entity.id!=null) {
            object = brandService.update( $scope.entity);
        }
        object.success(function (response) {
            if (response.flag) {
                //重新加载列表
                $scope.reloadList();
                alert("ok=" + response.messgae);
            } else {
                alert("no=" + response.messgae);
            }
        });
    };
    //更改
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (resonpse) {
            console.log("res=" + resonpse);
            $scope.entity = resonpse;
        })
    };

    //删除
    $scope.delete=function () {
        brandService.delete($scope.selectIds).success(function (response) {
            if (response.flag) {
                //清空数组
                $scope.selectIds=[];
                //重新加载列表
                $scope.reloadList();
                alert("ok=" + response.messgae);
            } else {
                alert("no=" + response.messgae);
            }
        });
    };

});
