package middleware

import (
	"fmt"
	"log"
	"strings"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/golang-jwt/jwt/v5"
)

func LoggerMIddleware() gin.HandlerFunc {
	return func(ctx *gin.Context) {
		timerq := time.Now()
		ctx.Next()
		durati := time.Since(timerq).Milliseconds()
		token := ctx.Request.Header.Get("Authorization")
		tken_wout_bearer := strings.SplitAfter(token, "Bearer ")
		fmt.Println(tken_wout_bearer[1])
		tokenString := tken_wout_bearer[1]
		fmt.Printf("The token is:\n%s\n", tokenString)
		var p jwt.Parser
		var clm jwt.Claims
		xtoken, b, err := p.ParseUnverified(tokenString, clm)
		if err != nil {
			fmt.Println(err.Error())
		}
		for _, p := range b {
			fmt.Printf("%s\n", p)
		}

		if claims, ok := xtoken.Claims.(jwt.MapClaims); ok {
			// obtains claims
			sub := fmt.Sprint(claims["bussinesscenter"])

			// and so on and on
			// ...
			fmt.Printf("sub = %s\r\n", sub)

		}
		method := ctx.Request.Method
		code := ctx.Writer.Status()
		url := ctx.Request.URL.String()
		client := ctx.ClientIP()
		log.Printf("Method: %s | URL: %s |Duration:%d ms | Code %d | IP: %s| Token: %s", method, url, durati, code, client, token)
	}
}
