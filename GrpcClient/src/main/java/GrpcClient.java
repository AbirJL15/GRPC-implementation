import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.User;
import org.example.userGrpc;

public class GrpcClient {
    public static void main(String[] args) {

        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        // stubs - generated from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginrequest = User.LoginRequest.newBuilder().setUsername("RAM").setPassword("RAM").build();
        User.APIResponse response = userStub.login(loginrequest);

        System.out.println(response.getResponsemessage());


    }
}
