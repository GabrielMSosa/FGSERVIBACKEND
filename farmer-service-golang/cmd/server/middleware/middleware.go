package middleware

import (
	"fmt"
	"log"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/golang-jwt/jwt/v5"
)

func LoggerMIddleware() gin.HandlerFunc {
	return func(ctx *gin.Context) {
		timerq := time.Now()
		ctx.Next()
		durati := time.Since(timerq).Milliseconds()
		tokenString := ctx.Request.Header.Get("Authorization")
		//tken_wout_bearer := strings.SplitAfter(token, "Bearer ")
		//fmt.Println(tken_wout_bearer[1])
		//tokenString := tken_wout_bearer[1]
		fmt.Printf("The token is:\n%s\n", tokenString)
		ptoken, err := jwt.Parse(tokenString, func(token *jwt.Token) (interface{}, error) {

			if _, ok := token.Method.(*jwt.SigningMethodHMAC); !ok {
				return nil, fmt.Errorf("Unexpected signing method: %v", token.Header["alg"])
			}

			// hmacSampleSecret is a []byte containing your secret, e.g. []byte("my_secret_key")
			return []byte("perrro"), nil
		})
		//if err != nil {
		//	log.Fatal(err)
		//}

		if claims, ok := ptoken.Claims.(jwt.MapClaims); ok {
			fmt.Println(claims["bussinesscenter"], claims["sub"])
		} else {
			fmt.Println(err)
		}

		method := ctx.Request.Method
		code := ctx.Writer.Status()
		url := ctx.Request.URL.String()
		client := ctx.ClientIP()
		log.Printf("Method: %s | URL: %s |Duration:%d ms | Code %d | IP: %s| Token: %s", method, url, durati, code, client, tokenString)
	}
}
