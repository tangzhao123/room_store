import request from '../utils/request.js';
export function getList(data){
	return request({
		url:'/type/select',
		method:'post',
		data
	})
}
export function addall(data){
  return request({
    url:'/type/insert',
    method:'post',
    data
  })
}
export function enit(data){
  return request({
    url:'/type/update',
    method:'put',
    data
  })
}
export function selectMap(){
  return request({
    url:'/type/selectMap',
    method:'get',
  })
}