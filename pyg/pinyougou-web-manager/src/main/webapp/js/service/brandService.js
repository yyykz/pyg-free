// Service层
app.service("brandService", function ($http) {
    this.findAll = function () {
        return $http.get("/web-manager/brand/findAll.do");
    }
    this.search = function (currentPage,itemsPerPage,searchEntity) {
        return $http.post("/web-manager/brand/search.do?pageNum=" + currentPage + "&&pageSize=" + itemsPerPage, searchEntity);
    }
    this.findPage=function (currentPage,itemsPerPage) {
        return $http.get("/web-manager/brand/findPage.do?pageNum=" + currentPage + "&&pageSize=" + itemsPerPage);
    }
    this.add=function (entity) {
        return $http.post('/web-manager/brand/add.do', entity);
    }
    this.update=function (entity) {
        return $http.post('/web-manager/brand/update.do', entity);
    }
    this.findOne=function(id){
        return $http.get('/web-manager/brand/findOne.do?id=' + id);
    }
    this.delete=function (selectIds) {
        return $http.get("/web-manager/brand/delete.do?ids="+selectIds);
    }
})
