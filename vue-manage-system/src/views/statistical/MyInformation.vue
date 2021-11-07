<template>
	<div>
		<div class="user-info" style="width: 100%;margin-top: 10px;">
			<div class="user-info-cont">
				本月统计
			</div>
		</div>
	</div>

</template>

<script>
</script>

<style>
	.user-info {
		display: flex;
		align-items: center;
		padding-bottom: 20px;
		border-bottom: 2px solid #ccc;
		margin-bottom: 20px;
	}

	.user-info-cont {
		padding-left: 50px;
		flex: 1;
		font-size: 14px;
		color: #999;
	}

	.user-info-cont div:first-child {
		font-size: 30px;
		color: #222;
	}
</style>
