import React, { useEffect, useState } from "react";
import {
  AppBar,
  Toolbar,
  Box,
  Card,
  Grid,
  Typography,
  Container,
} from "@mui/material";
import axios from "axios";

const Search = () => {
  const [post, setPost] = useState(null);

  useEffect(() => {
    const fetchInitialPosts = async () => {
      const response = await axios.get(`http://localhost:8080/jobPosts`);
      console.log(response);
      setPost(response.data);
    };
    fetchInitialPosts();
  }, []);

  return (
    <Box>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" align="center" sx={{ flexGrow: 1 }}>
            Job Portal
          </Typography>
        </Toolbar>
      </AppBar>

      <Container sx={{ marginTop: "2rem" }}>
        <Grid container spacing={3}>
          {post &&
            post.map((p) => (
              <Grid key={p.id} item xs={12} md={6} lg={4}>
                <Card
                  sx={{
                    padding: "1.5rem",
                    boxShadow: 4,
                    borderRadius: 2,
                    backgroundColor: "#f9f9f9",
                  }}
                >
                  <Typography
                    variant="h5"
                    sx={{ fontWeight: 600, marginBottom: "0.5rem" }}
                  >
                    {p.postProfile}
                  </Typography>

                  <Typography
                    variant="body1"
                    sx={{ color: "#585858", marginBottom: "1rem" }}
                  >
                    Description: {p.postDesc}
                  </Typography>

                  <Typography variant="body1" sx={{ marginBottom: "0.5rem" }}>
                    Experience: {p.reqExperience} years
                  </Typography>

                  <Typography variant="body2" sx={{ fontWeight: 500 }}>
                    Skills:
                  </Typography>
                  {p.postTechStack.map((s, i) => (
                    <Typography key={i} variant="body2" component="span">
                      {s}
                      {i < p.postTechStack.length - 1 ? ", " : ""}
                    </Typography>
                  ))}
                </Card>
              </Grid>
            ))}
        </Grid>
      </Container>
    </Box>
  );
};

export default Search;
