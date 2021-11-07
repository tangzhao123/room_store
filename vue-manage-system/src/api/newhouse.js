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