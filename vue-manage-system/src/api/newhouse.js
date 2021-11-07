import request from '../utils/request.js';
export function getList(data){
	return request({
		url:'/house/select',
		method:'post',
		data
	})
}