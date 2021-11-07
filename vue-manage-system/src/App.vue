<template>
	<router-view />
</template>

<script>
	export default {
		created() {
			if (sessionStorage.getItem("state")) {
				this.$store.replaceState(
					Object.assign({},
						this.$store.state,
						JSON.parse(sessionStorage.getItem("state"))
					)
				)
			}
		},
		mounted() {
			window.addEventListener('beforeunload', () => {
				this.$store.state.children = {}

				//刷新前将目前登录的用户保存到sessionStorage中
				sessionStorage.setItem('state', JSON.stringify(this.$store.state))
			})
		}
	};
</script>

<style>
	@import "./assets/css/main.css";
	@import "./assets/css/color-dark.css";
</style>
