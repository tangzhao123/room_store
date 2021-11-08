import request from '../utils/request.js';
export function getList(data){
	return request({
		url:'/house/select',
		method:'post',
		data
	})
}
export function addall(data){
  return request({
    url:'/house/save',
    method:'post',
    data
  })
}
export function enit(data){
  return request({
    url:'/house/update',
    method:'put',
    data
  })
}
export function selectList(){
	return request({
		url:'/chara/select',
		method:'get',
	})
}
export function selectByOne(data){
	return request({
		url:`/house/selectByOne/${data}`,
		data
	})
}
export function selectDetails(data){
	return request({
		url:`/house/selectDetails/${data}`,
		data
	})
}