/**
 * Created by anderson on 28/09/15.
 */
'use strict';

angular.module('controller', ['ngProgress', 'ui.bootstrap', 'ui.bootstrap.tpls', 'ngTable'])

    .controller('SearchCtrl', function ($scope, $rootScope, $http, $timeout, ngProgressFactory, NgTableParams) {


        $scope.start = function () {
            $scope.progressbar = ngProgressFactory.createInstance();

            $scope.progressbar.setColor('#0073c4');
            $scope.progressbar.setHeight('6px');
            $scope.progressbar.start();
            $scope.currentPage = 1;
        };

        $scope.listMostrar = [];
        $scope.itemsPerPage = 10;
        $scope.currentPage = 1;

        $scope.images = [];

        $scope.searched = false;
        $scope.skipInfo = false;

        $scope.searchMethod = function () {
            console.log("teste")
            $scope.start();

            $http.post('/demo/findById', {
                search: $scope.search,
                ajax: true
            }, {
                transformRequest: function (data) {
                    return $.param(data);
                }
            }).then(function (response){
                $scope.searched = true;
                console.log(response)
                $scope.selecionado = response.data;
                console.log($scope.selecionado)

                // $scope.pageChanged();

            });

            $http.get('https://api.gettyimages.com/v3/search/images?fields=id,title,thumb,referral_destinations&sort_order=best&phrase=' + $scope.search, {
                headers: {'Api-Key': '6q9uj3695ckk9m4u6cfxjz7e'}
            }).then(function (response) {
                console.log(response)
                console.log(response.data.images[1].display_sizes[0].uri)

                $scope.images = response.data.images
                $scope.imagem = response.data.images[1].display_sizes[0].uri
            });

            $scope.end();
            $scope.searched = true;

        };

        $scope.consultar = function () {
            console.log("teste")
            console.log($scope.nome)

            $http.post('/demo/consultar', {
                nome: $scope.nome,
                senha: $scope.senha,
                ajax: true
            }, {
                transformRequest: function (data) {
                    return $.param(data);
                }
            }).then(function (response){
                $scope.searched = true;
                console.log(response)
                $scope.selecionado = response.data;
                console.log($scope.selecionado)

                // $scope.pageChanged();

            });

            //window.open('mailto:test@example.com?subject=subject&body=body');
        }

        $scope.sendEmail = function () {
            console.log("teste")
            console.log($scope.nome)
            console.log($scope.email)

            //window.open('mailto:test@example.com?subject=subject&body=body');
        }

        $scope.skipInfoFun = function (item, index) {
            $scope.skipInfo = true;
        }

        $scope.teste = function (item, index) {
            // $scope.data[index].select = true;

            console.log($scope.data)
            $scope.data[0].select = true;

            console.log(item);
            $scope.search = item.id;
            $scope.searchMethod();

        }

        $scope.end = function () {
            $scope.progressbar.complete();
        }

        angular.element(document).ready(function () {
            $scope.progressbar.complete();
        });

        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };

        $scope.pageChanged = function() {
            console.log('Page changed to: ' + $scope.currentPage);
            for(var i = (($scope.currentPage - 1) * $scope.itemsPerPage) + 1, j = 0; i < ( $scope.currentPage - 1) * $scope.itemsPerPage + $scope.itemsPerPage && i < $scope.answer.length; i++, j++){
                $scope.listMostrar[j] = $scope.answer[i];
            }
            console.log($scope.listMostrar)
        };

        $scope.maxSize = 10;
        $scope.bigCurrentPage = 1;
    });
