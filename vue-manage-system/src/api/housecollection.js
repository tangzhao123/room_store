import request from '../utils/request.js';
export function getList(data){
	return request({
		url:'/source/select',
		method:'post',
		data
	})
}
export function addall(data){
  return request({
    url:'/source/insert',
    method:'post',
    data
  })
}
export function enit(data){
  return request({
    url:'/source/update',
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